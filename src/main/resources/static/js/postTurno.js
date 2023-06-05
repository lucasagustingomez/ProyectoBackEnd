window.addEventListener('load', function () {

    const formulario = document.querySelector('#add_new_turno');

    formulario.addEventListener('submit', function (event) {

        const formData = {
            pacienteId: document.querySelector('#id_paciente').value,
            odontologoId: document.querySelector('#id_odontologo').value,
            fecha: document.querySelector('#fecha').value,
        };
        const url = '/turnos';
        const settings = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        }

        fetch(url, settings)
            .then(response => response.json())
            .then(data => {
                 let successAlert = '<div class="alert alert-success alert-dismissible">' +

                     '<strong></strong> Turno agregado </div>'

                 document.querySelector('#response').innerHTML = successAlert;
                 document.querySelector('#response').style.display = "block";
                 resetUploadForm();

            })
            .catch(error => {
                    let errorAlert = '<div class="alert alert-danger alert-dismissible">' +

                                     '<strong> Error intente nuevamente cargar el turno</strong> </div>'

                      document.querySelector('#response').innerHTML = errorAlert;
                      document.querySelector('#response').style.display = "block";
                     resetUploadForm();})
    });


    function resetUploadForm(){
        document.querySelector('#id_paciente').value = "";
        document.querySelector('#id_odontologo').value = "";
         document.querySelector('#fecha').value = "";

    }

    (function(){
        let pathname = window.location.pathname;
        if(pathname === "/"){
            document.querySelector(".nav .nav-item a:first").addClass("active");
        } else if (pathname == "/listarTurnos.html") {
            document.querySelector(".nav .nav-item a:last").addClass("active");
        }
    })();
});







