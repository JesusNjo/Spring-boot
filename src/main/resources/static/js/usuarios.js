$(document).ready(function() {
  cargarUsuarios();

  $('#usuarios').DataTable();
});

async function cargarUsuarios() {
  try {
    const request = await fetch('api/usuarios', {
      method: 'GET',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      }
    });
    const usuarios = await request.json();

    console.log(usuarios);

    let listadoHtml= '';
    for(let usuario of usuarios) {

        let ustlf =usuario.telefono == null ? '-' : usuario.telefono;
      let btnEl = '<a href="#" onclick="eliminarUser('+usuario.id+')" class="btn btn-danger btn-circle btn-sm"> <i class="fas fa-trash"></i></a>';
      let usersHtml ='  <tr> <td>'+usuario.id+'</td>   <td>'+usuario.nombre + ' ' +usuario.apellido+'</td>   <td>'+usuario.email+'</td> <td>'+ustlf+'</td>  <td> '+btnEl+'</td> </tr>'
      listadoHtml+=usersHtml;
    }

    document.querySelector('#usuarios tbody').outerHTML = listadoHtml;
  } catch (error) {
    console.error('Error:', error);
  }
}

async function eliminarUser(id) {
  try {
  if(!confirm("¿Desea eliminar este usuario?")){
    return;
  }
const request = await fetch('api/usuarios/' + id, {

      method: 'DELETE',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      }
    });
    console.log(id);
    location.reload();
  } catch (error) {
    console.error('Error:', error);
  }
}
