// 
// Decompiled by Procyon v0.5.36
// 

package org.apache.log4j.net;

import java.util.Hashtable;
import org.apache.log4j.helpers.OptionConverter;
import javax.mail.Transport;
import java.util.Date;
import javax.mail.Multipart;
import javax.mail.BodyPart;
import javax.mail.internet.MimeMultipart;
import org.apache.log4j.Layout;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import org.apache.log4j.spi.LoggingEvent;
import javax.mail.PasswordAuthentication;
import javax.mail.Authenticator;
import java.util.Properties;
import javax.mail.Session;
import javax.mail.Address;
import javax.mail.MessagingException;
import org.apache.log4j.helpers.LogLog;
import javax.mail.internet.MimeMessage;
import org.apache.log4j.spi.TriggeringEventEvaluator;
import javax.mail.Message;
import org.apache.log4j.helpers.CyclicBuffer;
import org.apache.log4j.AppenderSkeleton;

public class SMTPAppender extends AppenderSkeleton
{
    private String to;
    private String cc;
    private String bcc;
    private String from;
    private String subject;
    private String smtpHost;
    private String smtpUsername;
    private String smtpPassword;
    private boolean smtpDebug;
    private int bufferSize;
    private boolean locationInfo;
    protected CyclicBuffer cb;
    protected Message msg;
    protected TriggeringEventEvaluator evaluator;
    
    public SMTPAppender() {
        this(new DefaultEvaluator());
    }
    
    public SMTPAppender(final TriggeringEventEvaluator evaluator) {
        this.smtpDebug = false;
        this.bufferSize = 512;
        this.locationInfo = false;
        this.cb = new CyclicBuffer(this.bufferSize);
        this.evaluator = evaluator;
    }
    
    public void activateOptions() {
        this.msg = (Message)new MimeMessage(this.createSession());
        try {
            this.addressMessage(this.msg);
            if (this.subject != null) {
                this.msg.setSubject(this.subject);
            }
        }
        catch (MessagingException t) {
            LogLog.error("Could not activate SMTPAppender options.", (Throwable)t);
        }
    }
    
    protected void addressMessage(final Message message) throws MessagingException {
        if (this.from != null) {
            message.setFrom((Address)this.getAddress(this.from));
        }
        else {
            message.setFrom();
        }
        if (this.to != null && this.to.length() > 0) {
            message.setRecipients(Message.RecipientType.TO, (Address[])this.parseAddress(this.to));
        }
        if (this.cc != null && this.cc.length() > 0) {
            message.setRecipients(Message.RecipientType.CC, (Address[])this.parseAddress(this.cc));
        }
        if (this.bcc != null && this.bcc.length() > 0) {
            message.setRecipients(Message.RecipientType.BCC, (Address[])this.parseAddress(this.bcc));
        }
    }
    
    protected Session createSession() {
        Properties properties;
        try {
            properties = new Properties(System.getProperties());
        }
        catch (SecurityException ex) {
            properties = new Properties();
        }
        if (this.smtpHost != null) {
            ((Hashtable<String, String>)properties).put("mail.smtp.host", this.smtpHost);
        }
        Authenticator authenticator = null;
        if (this.smtpPassword != null && this.smtpUsername != null) {
            ((Hashtable<String, String>)properties).put("mail.smtp.auth", "true");
            authenticator = new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(SMTPAppender.this.smtpUsername, SMTPAppender.this.smtpPassword);
                }
            };
        }
        final Session instance = Session.getInstance(properties, authenticator);
        if (this.smtpDebug) {
            instance.setDebug(this.smtpDebug);
        }
        return instance;
    }
    
    public void append(final LoggingEvent event) {
        if (!this.checkEntryConditions()) {
            return;
        }
        event.getThreadName();
        event.getNDC();
        event.getMDCCopy();
        if (this.locationInfo) {
            event.getLocationInformation();
        }
        this.cb.add(event);
        if (this.evaluator.isTriggeringEvent(event)) {
            this.sendBuffer();
        }
    }
    
    protected boolean checkEntryConditions() {
        if (this.msg == null) {
            super.errorHandler.error("Message object not configured.");
            return false;
        }
        if (this.evaluator == null) {
            super.errorHandler.error("No TriggeringEventEvaluator is set for appender [" + super.name + "].");
            return false;
        }
        if (super.layout == null) {
            super.errorHandler.error("No layout set for appender named [" + super.name + "].");
            return false;
        }
        return true;
    }
    
    public synchronized void close() {
        super.closed = true;
    }
    
    InternetAddress getAddress(final String str) {
        try {
            return new InternetAddress(str);
        }
        catch (AddressException ex) {
            super.errorHandler.error("Could not parse address [" + str + "].", (Exception)ex, 6);
            return null;
        }
    }
    
    InternetAddress[] parseAddress(final String str) {
        try {
            return InternetAddress.parse(str, true);
        }
        catch (AddressException ex) {
            super.errorHandler.error("Could not parse address [" + str + "].", (Exception)ex, 6);
            return null;
        }
    }
    
    public String getTo() {
        return this.to;
    }
    
    public boolean requiresLayout() {
        return true;
    }
    
    protected void sendBuffer() {
        try {
            final MimeBodyPart mimeBodyPart = new MimeBodyPart();
            final StringBuffer sb = new StringBuffer();
            final String header = super.layout.getHeader();
            if (header != null) {
                sb.append(header);
            }
            for (int length = this.cb.length(), i = 0; i < length; ++i) {
                final LoggingEvent value = this.cb.get();
                sb.append(super.layout.format(value));
                if (super.layout.ignoresThrowable()) {
                    final String[] throwableStrRep = value.getThrowableStrRep();
                    if (throwableStrRep != null) {
                        for (int j = 0; j < throwableStrRep.length; ++j) {
                            sb.append(throwableStrRep[j]);
                            sb.append(Layout.LINE_SEP);
                        }
                    }
                }
            }
            final String footer = super.layout.getFooter();
            if (footer != null) {
                sb.append(footer);
            }
            mimeBodyPart.setContent((Object)sb.toString(), super.layout.getContentType());
            final MimeMultipart content = new MimeMultipart();
            ((Multipart)content).addBodyPart((BodyPart)mimeBodyPart);
            this.msg.setContent((Multipart)content);
            this.msg.setSentDate(new Date());
            Transport.send(this.msg);
        }
        catch (Exception t) {
            LogLog.error("Error occured while sending e-mail notification.", t);
        }
    }
    
    public String getEvaluatorClass() {
        return (this.evaluator == null) ? null : this.evaluator.getClass().getName();
    }
    
    public String getFrom() {
        return this.from;
    }
    
    public String getSubject() {
        return this.subject;
    }
    
    public void setFrom(final String from) {
        this.from = from;
    }
    
    public void setSubject(final String subject) {
        this.subject = subject;
    }
    
    public void setBufferSize(final int n) {
        this.bufferSize = n;
        this.cb.resize(n);
    }
    
    public void setSMTPHost(final String smtpHost) {
        this.smtpHost = smtpHost;
    }
    
    public String getSMTPHost() {
        return this.smtpHost;
    }
    
    public void setTo(final String to) {
        this.to = to;
    }
    
    public int getBufferSize() {
        return this.bufferSize;
    }
    
    public void setEvaluatorClass(final String className) {
        this.evaluator = (TriggeringEventEvaluator)OptionConverter.instantiateByClassName(className, TriggeringEventEvaluator.class, this.evaluator);
    }
    
    public void setLocationInfo(final boolean locationInfo) {
        this.locationInfo = locationInfo;
    }
    
    public boolean getLocationInfo() {
        return this.locationInfo;
    }
    
    public void setCc(final String cc) {
        this.cc = cc;
    }
    
    public String getCc() {
        return this.cc;
    }
    
    public void setBcc(final String bcc) {
        this.bcc = bcc;
    }
    
    public String getBcc() {
        return this.bcc;
    }
    
    public void setSMTPPassword(final String smtpPassword) {
        this.smtpPassword = smtpPassword;
    }
    
    public void setSMTPUsername(final String smtpUsername) {
        this.smtpUsername = smtpUsername;
    }
    
    public void setSMTPDebug(final boolean smtpDebug) {
        this.smtpDebug = smtpDebug;
    }
    
    public String getSMTPPassword() {
        return this.smtpPassword;
    }
    
    public String getSMTPUsername() {
        return this.smtpUsername;
    }
    
    public boolean getSMTPDebug() {
        return this.smtpDebug;
    }
}
