function formCheck() {
    // 유효값 검사를 실행해야하는 목록
    const name = document.getElementById("name").value;
    const id = document.getElementById("id").value;
    const pw = document.getElementById("pw").value;
    const cpw = document.getElementById("confirmPw").value;
    const email = document.getElementsByName("email"); // 배열
    const address = document.getElementsByName("address"); // 배열
    const mobileNum = document.getElementsByName("mobileNum") // 배열
    const mobileCarrier = document.getElementsByName("mobileCarrier") // 배열

    var flag = true;

    // Name check
    if (flag) {
        if (isEmptyId("name")) {
            alert("이름을 입력하세요.");
            flag = false;
        } else {
            if (name.length < 2 || name.length > 4) {
                alert("이름은 2~4자 사이로 입력하세요.");
                flag = false;
            }
        }
    }

    // Id check
    if (flag) {
        if (isEmptyId("id")) {
            alert("아이디를 입력하세요.");
            flag = false;
        } else {
            if (id.length < 3 || name.length >12) {
                alert("아이디는 3~12자 사이로 입력하세요.");
                flag = false;
            }
        }
    }

    // Password Check1
    if (flag) {
        if (isEmptyId("pw")) {
            alert("비밀번호를 입력하세요");
            flag = false;
        } else {
            if (pw.length < 5 || pw.length >8) {
                alert("비밀번호는 5~8자 사이로 입력하세요.");
                flag = false;
            }
        }
    }

    //passwrod Check2
    if (flag) {
        if (isEmptyId("confirmPw")) {
            alert("비밀번호 다시입력을 입력하세요.");
            flag = false;
        } else {
            if (cpw.length < 5 || cpw.length >8) {
                alert("비밀번호 다시입력은 5~8자 사이로 입력하세요.");
                flag = false;
            }
        }
    }

    //password equality check
    if (flag) {
        if (pw != cpw) {
            alert("비밀번호와 비밀번호 다시입력은 서로 같아야 합니다.");
            flag = false;
        }
    }

    // email check
    if (flag) {
        if (isEmptyName("email")) {
            alert("이메일을 정확하게 입력하세요.")
            flag = false;
        }
    }

    // address check
    if (flag) {
        if (isEmptyName("address")) {
            alert("주소를 빈칸이 없도록 입력하세요.")
            flag = false;
        } else {
            var numCheck = isNumeric(address[0].value) && isNumeric(address[1].value);
            if (!numCheck) {
                alert("우편번호는 숫자를 입력하세요.");
                flag = false;
            }
        }
    }

    // mobile num check
    if (flag) {
        var numCheck = isNumeric(mobileNum[0].value) && isNumeric(mobileNum[1].value) && isNumeric(mobileNum[2].value);
        if(isEmptyName("mobileNum")) {
            alert("휴대폰번호를 입력하세요.");
            flag = false;
        } else if(!numCheck) {
            alert("휴대폰 번호는 숫자만 입력하세요.");
            flag = false;    
        } else {
            var checked = false;
    
            for (var i=0; i<mobileCarrier.length; i++) {
                if (mobileCarrier[i].checked) {
                    checked = true;
                    break;
                }
            }
    
            if (!checked) {
                alert("통신사를 선택하세요.");
                flag = false;
            }
        }
    }

    return flag;
}
function giveAddress (form) {
    const address = form.emailDomain.selectedIndex;

    switch (address) {
        case 0:
            form.email[1].value = "우측에서 선택";
            break;
        case 1: // 구글 이메일
            form.email[1].value = "google.com";
            break;
        case 2: // 네이버
            form.email[1].value = "naver.com";
            break;
        case 3: // 다음
            form.email[1].value = "hanmail.net";
            break;
        case 4: // 직접입력
            form.email[1].value = "";
            break;
    }

    return true;
}

function fixCheonrian (form) {
    const checkObj = document.getElementById("cheonrian");
    const check = checkObj.checked;

    if (check) {
        form.email[1].value = "chollian.net";
    }

    return true;
}

function duplicateCheckId() {
    const testSetId = ['test1', 'test2', 'test3']; // 서버가 없어서 임시로 만듦
    const id = document.getElementById("id").value;
    var flag = isEmptyId("id");

    if (flag){
        alert("아이디를 입력하세요.");
    } else{
        flag = true;

        for (var i=0; i<testSetId.length; i++){
            if(testSetId[i] == id){
                alert("중복된 아이디입니다.");
                flag = false;
                break;
            }
        }
    
        if (flag) {
            flag = confirm("중복되지 않았습니다. 이 아이디(" + id + ")로 하시겠습니까?");
        }

        if (!flag){
            document.getElementById("id").value="";
        }
    }

    return flag;
}

function openAddressBook() {
    window.open("https://www.epost.go.kr/search.RetrieveIntegrationNewZipCdList.comm", "우편번호 찾기", "width=400, height=400")
}

function isEmptyName(name){
    const data = document.getElementsByName(name);
    var flag = false;

    if (data == null || data == undefined){
        flag = true;
    } else {
        for (var i=0; i<data.length; i++) {
            if (data[i].value == "") {
                flag = true;
                break;
            }
        }
    }

    return flag;
}

function isEmptyId(id){
    const data = document.getElementById(id).value;
    var flag = false;

    if (data == "" || data == null || data == undefined) {
        flag = true;
    }

    return flag;
}

function isNumeric(num, opt){
    // 좌우 trim(공백제거)을 해준다.
    num = String(num).replace(/^\s+|\s+$/g, "");
   
    if (typeof opt == "undefined" || opt == "1") {
      // 모든 10진수 (부호 선택, 자릿수구분기호 선택, 소수점 선택)
      var regex = /^[+\-]?(([1-9][0-9]{0,2}(,[0-9]{3})*)|[0-9]+){1}(\.[0-9]+)?$/g;
    } else if(opt == "2") {
      // 부호 미사용, 자릿수구분기호 선택, 소수점 선택
      var regex = /^(([1-9][0-9]{0,2}(,[0-9]{3})*)|[0-9]+){1}(\.[0-9]+)?$/g;
    } else if (opt == "3") {
      // 부호 미사용, 자릿수구분기호 미사용, 소수점 선택
      var regex = /^[0-9]+(\.[0-9]+)?$/g;
    } else {
      // only 숫자만(부호 미사용, 자릿수구분기호 미사용, 소수점 미사용)
      var regex = /^[0-9]$/g;
    }
   
    if (regex.test(num)) {
      num = num.replace(/,/g, "");
      return isNaN(num) ? false : true;
    } else { 
        return false;  
    }
}