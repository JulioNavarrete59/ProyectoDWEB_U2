'use strict'

// Select
let clientes, empleados, ventas;

let autos = [
    {id: 1, marca: 'Marca1', modelo: 'Modelo1', anio: '2021', precio: 10000},
    {id: 2, marca: 'Marca2', modelo: 'Modelo2', anio: '2022', precio: 20000},
    // ... más autos ...
];
var cars = [];
// Modelos
let cliente_id = '', empleado_id = '', fecha_venta, metodo_Pago;

let total = 0, ice = 0, totalPagar = 0;

function agregarAuto (){
    cars.push({
        auto_id: '',
        cantidad: 1,
        precio: 0,
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

function actualizarTabla() {
    var tabla = $('#cuerpoTabla');
    tabla.empty();
    for (var i = 0; i < cars.length; i++) {
        var select = $('<select id="auto_id' + i + '"></select>');
        select.append('<option value="0">Seleccione un auto</option>');
        for (var j = 0; j < autos.length; j++) {
            select.append('<option value="' + autos[j].id + '">' + autos[j].marca + ' ' + autos[j].modelo + ' ' + autos[j].anio + '</option>');
        }
        var fila = $(
            '<tr><td>' +
            select.prop('outerHTML') + '</td><td>' +
            '<input type="number" id="cantidad' + i + '" value="' + cars[i].cantidad + '">' + '</td><td>' +
            cars[i].precio + '</td><td>' +
            cars[i].subtotal + '</td></tr>'
        );
        tabla.append(fila);
        $('#auto_id' + i).change(function() {
            changeCar(i);
        });
        $('#cantidad' + i).change(function() {
            changeQuality(i);
        });
    }
}



function deleteCar(key) {
    this.cars.splice(key, 1);
    this.updateValues();
}

function changeCar(key) {
    let auto_id = this.cars[key]['auto_id'];
    // Aquí necesitarías buscar el auto en tu base de datos
    let auto = findAuto(auto_id);

    this.cars[key]['precio'] = auto.precio;
    this.cars[key]['subtotal'] = this.cars[key]['cantidad'] * auto.precio;

    this.updateValues();
}
function changeQuality(key) {
    if (this.cars[key]['auto_id'] != '') {
        this.cars[key]['subtotal'] = this.cars[key]['cantidad'] * this.cars[key]['precio'];
    }

    this.updateValues();
}

function updateValues() {
    this.total = 0;
    this.ice = 0;
    this.totalPagar = 0;

    for (let key in this.cars) {
        this.total += parseFloat(this.cars[key]['subtotal']);
    }

    this.ice = this.total * 0.17;
    this.totalPagar = this.total + this.ice;

    this.total = Math.round(this.total * 100) / 100;
    this.ice = Math.round(this.ice * 100) / 100;
    this.totalPagar = Math.round(this.totalPagar * 100) / 100;
}

function saveSale() {
    // Aquí necesitarías validar tus campos y guardar la venta en tu base de datos

}

// Función para buscar un auto en la base de datos
function findAuto(auto_id) {
    // Aquí necesitarías buscar el auto en tu base de datos y devolverlo

}
