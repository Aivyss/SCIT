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
    var flag = true;

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

    return flag;
}

function openAddressBook() {
    window.open("https://www.epost.go.kr/search.RetrieveIntegrationNewZipCdList.comm", "우편번호 찾기", "width=400, height=400")
}