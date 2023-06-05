window.addEventListener('load', function () {

    const formulario = document.querySelector('#add_new_odontologo');

    formulario.addEventListener('submit', function (event) {
        event.preventDefault();
        const formData = {
            nombre: document.querySelector('#nombre').value,
            apellido: document.querySelector('#apellido').value,
            matricula: document.querySelector('#matricula').value,
        }
       console.log(formData.nroMatricula)
        const url = '/odontologos';
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
                    '<strong></strong> Odontologo Registrado </div>'

                document.querySelector('#response').innerHTML = successAlert;
                document.querySelector('#response').style.display = "block";
                resetUploadForm();
                
            })
            .catch(error => {
                    let errorAlert = '<div class="alert alert-danger alert-dismissible">' +

                                    '<strong> Error intente nuevamente</strong> </div>'

                    document.querySelector('#response').innerHTML = errorAlert;
                    document.querySelector('#response').style.display = "block";
                    resetUploadForm();})
    });


    function resetUploadForm(){
        document.querySelector('#nombre').value = "";
        document.querySelector('#apellido').value = "";
         document.querySelector('#matricula').value = "";

    }

    (function(){
        let pathname = window.location.pathname;
        if(pathname === "/"){
            document.querySelector(".nav .nav-item a:first").addClass("active");
        } else if (pathname == "/listarOdontologo.html") {
            document.querySelector(".nav .nav-item a:last").addClass("active");
        }
    })();
});