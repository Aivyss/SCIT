function formCheck() {
    // 유효값 검사를 실행해야하는 목록
    var name = document.getElementById("name").value;
    var id = document.getElementById("id").value;
    var pw = document.getElementById("pw").value;
    var cpw = document.getElementById("confirmPw").value;
    var email = document.getElementsByName("email"); // 배열
    var address = document.getElementsByName("address"); // 배열
    var mobileNum = document.getElementsByName("mobileNum") // 배열
    var mobileCarrier = document.getElementsByName("mobileCarrier") // 배열

    var flag = true;

    if (isEmptyId("name")) {
        alert("이름을 입력하세요.");
        flag = false;
    } else {
        if (isEmptyId("id")) {
            alert("아이디를 입력하세요.");
            flag = false;
        } else {
            if(isEmptyId("pw")){
                alert("비밀번호를 입력하세요.");
                flag = false;
            } else {
                if (isEmptyId("confirmPw")) {
                    alert("비밀번호 다시입력을 입력하세요.");
                    flag = false;
                } else {
                    if (isEmptyName("email")) {
                        alert("이메일을 정확하게 입력하세요.")
                        flag = false;
                    } else {
                        if (isEmptyName("address")) {
                            alert("주소를 빈칸이 없도록 입력하세요.")
                            flag = false;
                        } else {
                            if(isEmptyName("mobileNum")) {
                                alert("휴대폰번호를 입력하세요.")
                                flag = false;
                            } else {
                                if (isEmptyName("mobileCarrier")) {
                                    alert("통신사를 선택하세요.")
                                    flag = false;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    return flag;
}
function giveAddress (form) {
    var address = form.emailDomain.selectedIndex;

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
    var checkObj = document.getElementById("cheonrian");
    var check = checkObj.checked;

    if (check) {
        form.email[1].value = "chollian.net";
    }

    return true;
}

function duplicateCheckId() {
    var testSetId = ['test1', 'test2', 'test3']; // 서버가 없어서 임시로 만듦
    var id = document.getElementById("id").value;
    var flag = isEmptyId(id);

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
    }

    return flag;
}

function openAddressBook() {
    window.open("https://www.epost.go.kr/search.RetrieveIntegrationNewZipCdList.comm", "우편번호 찾기", "width=400, height=400")
}

function isEmptyName(name){
    var data = document.getElementsByName(name);
    var flag = false;

    // for (var item in data){
    //     if (item.value == "") {
    //         flag = true;
    //         break;
    //     }
    // }

    for (var i=0; i<data.length; i++) {
        if (data[i].value == "") {
            flag = true;
            break;
        }
    }

    return flag;
}

function isEmptyId(id){
    var data = document.getElementById(id).value;
    var flag = false;

    if (data == "") {
        flag = true;
    }

    return flag;
}