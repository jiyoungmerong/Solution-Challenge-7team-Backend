window.addEventListener('DOMContentLoaded', () => {
    // 메시지 데이터를 가져오는 Ajax 요청
    fetch('/message_list')  // 적절한 엔드포인트로 변경해야 함
        .then(response => response.json())
        .then(messages => {
            const messageList = document.getElementById('message-list');

            messages.forEach(message => {
                const li = document.createElement('li');

                const nickname = document.createElement('span');
                nickname.className = 'nickname';
                nickname.textContent = message.nickname;

                const content = document.createElement('div');
                content.className = 'message';
                content.textContent = message.content;

                li.appendChild(nickname);
                li.appendChild(content);

                messageList.appendChild(li);
            });
        })
        .catch(error => {
            console.error('Error fetching messages:', error);
        });
});
