document.addEventListener('DOMContentLoaded', function() {
    const sections = document.querySelectorAll('.section'); // 모든 섹션 요소 선택
    const footer = document.querySelector('footer'); // 푸터 요소 선택
    const windowHeight = window.innerHeight; // 브라우저 창의 높이
    let currentSectionIndex = 0; // 현재 섹션 인덱스

    function scrollToSection(index) {
        sections[index].scrollIntoView({ behavior: 'smooth' }); // 해당 섹션으로 부드럽게 스크롤
    }

    function determineCurrentSection() {
        const scrollPosition = window.scrollY; // 스크롤 위치

        sections.forEach((section, index) => {
            const sectionTop = section.offsetTop; // 섹션의 맨 위 위치

            if (scrollPosition >= sectionTop && scrollPosition < sectionTop + section.clientHeight) {
                currentSectionIndex = index; // 현재 섹션 인덱스 업데이트
            }
        });
    }

    function handleScroll() {
        determineCurrentSection(); // 현재 보이는 섹션 확인

        if (window.scrollY + windowHeight >= footer.offsetTop) {
            currentSectionIndex = sections.length - 1; // 푸터에 도달하면 마지막 섹션으로 설정
        }

        window.removeEventListener('scroll', handleScroll); // 스크롤 이벤트 제거
        scrollToSection(currentSectionIndex); // 해당 섹션으로 스크롤
        setTimeout(() => {
            window.addEventListener('scroll', handleScroll); // 일정 시간 후에 다시 스크롤 이벤트 추가
        }, 1000);
    }

    window.addEventListener('scroll', handleScroll); // 스크롤 이벤트 추가
});