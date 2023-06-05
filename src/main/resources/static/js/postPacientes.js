window.addEventListener('load', function () {

    const formulario = document.querySelector('#add_new_paciente');


    formulario.addEventListener('submit', function (event) {
 event.preventDefault();
        const formData = {

                    apellido: document.querySelector('#apellido').value,
                    nombre: document.querySelector('#nombre').value,
                    documento: document.querySelector('#documento').value,
                    fechaIngreso: document.querySelector('#fechaIngreso').value,
                    domicilio:{
                        calle: document.querySelector('#calle').value,
                        numero: document.querySelector('#numero').value,
                        localidad: document.querySelector('#localidad').value,
                        provincia: document.querySelector('#provincia').value,
                    }

        };
        const url = '/pacientes';
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

                     '<strong></strong> Paciente agregado </div>'

                 document.querySelector('#response').innerHTML = successAlert;
                 document.querySelector('#response').style.display = "block";
                 resetUploadForm();

            })
            .catch(error => {
                    let errorAlert = '<div class="alert alert-danger alert-dismissible">' +

                                     '<strong> Error intente nuevamente cargar el paciente</strong> </div>'

                      document.querySelector('#response').innerHTML = errorAlert;
                      document.querySelector('#response').style.display = "block";
                     //se dejan todos los campos vacíos por si se quiere ingresar otro paciente
                     resetUploadForm();})
    });


    function resetUploadForm(){
                             apellido: document.querySelector('#apellido').value = "";
                             nombre: document.querySelector('#nombre').value = "";
                             documento: document.querySelector('#documento').value = "";
                             fechaIngreso: document.querySelector('#fechaIngreso').value = "";
                             domicilio:{
                                 calle: document.querySelector('#calle').value = "";
                                 numero: document.querySelector('#numero').value = "";
                                 localidad: document.querySelector('#localidad').value = "";
                                 provincia: document.querySelector('#provincia').value = "";
                             }

    }

    (function(){
        let pathname = window.location.pathname;
        if(pathname === "/"){
            document.querySelector(".nav .nav-item a:first").addClass("active");
        } else if (pathname == "/listarPacientes.html") {
            document.querySelector(".nav .nav-item a:last").addClass("active");
        }
    })();
});