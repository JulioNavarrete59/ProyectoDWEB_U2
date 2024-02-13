function validarContraseñas() {
    var newPassword = document.getElementById('form:newPassword').value;
    var confirmPassword = document.getElementById('form:confirmPassword').value;

    if (newPassword !== confirmPassword) {
        document.getElementById('form:confirmPassword').setCustomValidity("Las contraseñas no coinciden. Por favor, ingrésalas nuevamente.");
        return false;
    } else {
        document.getElementById('form:confirmPassword').setCustomValidity('');
        return true;
    }
}