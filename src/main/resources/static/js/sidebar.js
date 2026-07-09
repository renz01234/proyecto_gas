document.addEventListener("DOMContentLoaded", function () {

    const btn = document.getElementById("btnMenu");
    const sidebar = document.getElementById("sidebar");
    const contenido = document.getElementById("contenido");

    if(btn && sidebar && contenido){

        btn.addEventListener("click", function () {

            sidebar.classList.toggle("oculto");
            contenido.classList.toggle("expandido");

        });

    }

});