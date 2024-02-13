'use strict'
var autos = [];
function agregarAuto (){
    autos.push({
        auto_id: '',
        cantidad: 1,
        precio:0,
        subtotal: 0
    });
    actualizarTabla();

    /*var marca = document.getElementById('marca').value;
    var modelo = document.getElementById('modelo').value;
    var precio = document.getElementById('precio').value;
    var anio = document.getElementById('anio').value;
    var kilometraje = document.getElementById('kilometraje').value;
    var color = document.getElementById('color').value;

    var auto = {
        marca: marca,
        modelo: modelo,
        precio: precio,
        anio: anio,
        kilometraje: kilometraje,
        color: color
    };
    var autos = JSON.parse(localStorage.getItem('autos'));
    if (autos == null){
        autos = [];
    }
    autos.push(auto);
    localStorage.setItem('autos', JSON.stringify(autos));
    alert('Auto agregado');*/
}

function actualizarTabla (){
    var tabla = $('#cuerpoTabla');
    tabla.empty();
    for (var i = 0; i < autos.length; i++){
        tabla.append(
            '<tr><td>' +
            autos[i].auto_id + '</td><td>' +
            autos[i].cantidad + '</td><td>' +
            autos[i].precio + '</td><td>' +
            autos[i].subtotal + '</td></tr>'
        )
    }
}