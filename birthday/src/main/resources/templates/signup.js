document.getElementById("signup-form").addEventListener("submit", function(event) {
    event.preventDefault(); // 기본 폼 제출 동작 방지

    // 사용자 입력 가져오기
    let userId = document.getElementById("userId").value;
    let name = document.getElementById("name").value;
    let email = document.getElementById("email").value;
    let password = document.getElementById("password").value;

    // 데이터를 서버로 전송
    let data = {
        userId: userId,
        name: name,
        email: email,
        password: password
    };

    fetch("/signup", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(data)
    })
        .then(response => response.json())
        .then(result => {
            console.log(result); // 서버 응답 확인
            // 원하는 동작 수행 (예: 회원가입 성공 메시지 표시 등)
        })
        .catch(error => {
            console.error("Error:", error);
            // 에러 처리
        });
});
