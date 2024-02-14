'use strict'

var clientes, empleados, ventas;
var cars = [];
var autos = [];

var cliente_id = '', empleado_id = '', fecha_venta, metodo_Pago;

var total = 0, ice = 0, totalPagar = 0;

function agregarAuto (){
    cars.push({
        auto_id: '',
        cantidad: 1,
        precio: 0,
        subtotal: 0
    });
    actualizarTabla();
}

function actualizarTabla() {
    var tabla = $('#cuerpoTabla');
    tabla.empty();

    for (var i = 0; i < cars.length; i++) {
        var select = $('<select id="auto_id' + i + '"></select>');
        select.append('<option value="0">Seleccione un auto</option>');
        for (var j = 0; j < autos.length; j++) {
            select.append('' +
                '<h:pannelGrid columns="4" styleClass="container">' +
                '<h:outputLabel for="auto_id" value="Auto" styleClass="form-label" />' +
                '     <h:selectOneMenu id="auto_id" value="#{autosBean.auto}" required="true" styleClass="form-select">' +
                '         <f:selectItems value="#{autosBean.obtenerAuto()}" var="auto" itemValue="#{auto.idAuto}" itemLabel="#{auto.marca} #{auto.modelo}" />' +
                '     </h:selectOneMenu>' +
                '<h:inputText value="#{ventasBean.detalle.cantidad}" />' +
                '<h:inputText value="#{ventasBean.auto.precio}" />' +
                '<h:inputText value="#{ventasBean.detalle.subtotal}" />' +
                '</h:pannelGrid>')
        }
        var fila = $(
            '<tr><td>' +
            select.prop('outerHTML') + '</td><td>' +
            '<input type="number" id="cantidad' + i + '" value="' + cars[i].cantidad + '">' + '</td><td>' +
            '<input type="number" id="precio' + i + '" value="' + cars[i].precio + '" disabled>' + '</td><td>' +
            '<input type="number" id="subtotal' + i + '" value="' + cars[i].subtotal + '" disabled>' + '</td></tr>'
        );
        tabla.append(fila);

        $('#auto_id' + i).change(function (event) {
            var selectedAutoId = $(event.target).val();
            updateCarData(i, selectedAutoId);
        });

        $('#cantidad' + i).change(function () {
            changeQuality(i);
        });
    }
}

function updateCarData(carIndex, selectedAutoId) {
    var selectedAuto = findAutoById(selectedAutoId);

    if (selectedAuto) {
        cars[carIndex]['auto_id'] = selectedAuto.id;
        cars[carIndex]['precio'] = selectedAuto.precio;
        cars[carIndex]['subtotal'] = cars[carIndex]['cantidad'] * selectedAuto.precio;
    } else {
        cars[carIndex]['auto_id'] = '';
        cars[carIndex]['precio'] = 0;
        cars[carIndex]['subtotal'] = 0;
    }
    actualizarTabla();
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
function findAutoById(autoId) {
    for (var i = 0; i < autos.length; i++) {
        if (autos[i].id === autoId) {
            return autos[i];
        }
    }
    return null;
}
