// 상세 안내 버튼 js 
document.addEventListener('DOMContentLoaded', function() {
    const toggleBtns = document.querySelectorAll('.section2-toggle-btn');

    toggleBtns.forEach(btn => {
        const icon = btn.querySelector('span');
        const sbottom = btn.closest('.section2-top').nextElementSibling;
        
        btn.addEventListener('click', (event) => {
            event.preventDefault(); 
            icon.classList.toggle('rotate-180');
            sbottom.classList.toggle('active');
        });
    });
});