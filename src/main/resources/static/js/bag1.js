
// Cerrar la ventana emergence
let close_button = document.getElementById('close-button');
close_button.addEventListener("click", function(e) {
    e.preventDefault();
    document.getElementById("ventanax").style.display = "none";
});

// declaramos las variables
function init(){
    var resultado = document.getElementById('resultado');
}

function resolver(){
    var mensaje = "Su contacto ha sido enviado correctamente";
    
    resultado.textContent = mensaje;

    document.getElementById("ventanax").style.display="block";
}