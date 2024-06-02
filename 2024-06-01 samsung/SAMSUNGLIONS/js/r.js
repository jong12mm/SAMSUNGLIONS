document.addEventListener('DOMContentLoaded', function() {
    const toggleBtns = document.querySelectorAll('.section2-toggle-btn');

    toggleBtns.forEach(btn => {
        btn.addEventListener('click', function(event) {
            event.preventDefault();
            const icon = btn.querySelector('span');
            const sbottom = btn.parentElement.nextElementSibling;
            sbottom.classList.toggle('active');
            icon.classList.toggle('rotate-180');

            const section = sbottom.closest('.main-section2');
            let originalHeight = section.scrollHeight;

            if (sbottom.classList.contains('active')) {
                const sbottomHeight = sbottom.scrollHeight;
                section.style.height = `${originalHeight + sbottomHeight}px`;
            } else {
                section.style.height = `${originalHeight}px`;
            }
        });
    });
});
