

$(document).ready(function() {


    // un-ready
});


async function createUser(){
let datos ={};
datos.nombre = document.getElementById("txtNombre").value;
datos.apellido = document.getElementById("txtApellido").value;
datos.email = document.getElementById("txtEmail").value;
datos.password = document.getElementById("txtPassword").value;
let RepeatPassWord = document.getElementById("txtRepeatPassword").value;

if(RepeatPassWord != datos.password){
    alert("Las contraseña no coincide");
    return;
}
const request = await fetch('api/usuarios', {
    method: 'POST',
    headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
    },
    body: JSON.stringify(datos),
});



}
