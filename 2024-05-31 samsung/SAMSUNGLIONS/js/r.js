document.addEventListener('DOMContentLoaded', function() {
    const toggleBtn1 = document.querySelector('.section2-toggle-btn1');
    const toggleBtn2 = document.querySelector('.section2-toggle-btn2');
    const toggleBtn3 = document.querySelector('.section2-toggle-btn3');

    const toggleSection = (btn, index) => {
        const icon = btn.querySelector('span');
        const sbottom = btn.closest('.section2-top').nextElementSibling;
        const section = btn.closest('.main-section2');
        let originalHeight = section.scrollHeight;

        btn.addEventListener('click', (event) => {
            event.preventDefault(); 
            icon.classList.toggle('rotate-180');
            sbottom.classList.toggle('active');

            if (sbottom.classList.contains('active')) {
                const sbottomHeight = sbottom.scrollHeight;
                const pHeight = sbottom.querySelector('p').offsetHeight;
                section.style.height = `${originalHeight + sbottomHeight + pHeight}px`;
            } else {
                const sbottomHeight = sbottom.scrollHeight;
                const pHeight = sbottom.querySelector('p').offsetHeight;
                section.style.height = `${originalHeight - sbottomHeight - pHeight}px`;
            }
        });
    };

    toggleSection(toggleBtn1, 1);
    toggleSection(toggleBtn2, 2);
    toggleSection(toggleBtn3, 3);
});


