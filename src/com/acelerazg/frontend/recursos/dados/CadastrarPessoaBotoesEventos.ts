export class CadastrarPessoaBotoesEventos {

    public static botoesCadastroPessoa() {

        const mostrarFormularioEmpresa = document.getElementById('mostrarFormularioEmpresa');
        const mostrarFormularioCandidato = document.getElementById('mostrarFormularioCandidato');
        const formEmpresa = document.getElementById('form-empresa');
        const formCandidato = document.getElementById('form-candidato');

        if (formEmpresa && formCandidato && mostrarFormularioEmpresa && mostrarFormularioCandidato) {

            formEmpresa.addEventListener('submit', function (event) {
                const competencias = document.querySelectorAll('#empresaCompetencias input[type="checkbox"]:checked');

                if (competencias.length === 0) {
                    event.preventDefault();
                    alert('Selecione pelo menos uma competência.');
                }
            });

            formCandidato.addEventListener('submit', function (event) {
                const competencias = document.querySelectorAll('#candidatoCompetencias input[type="checkbox"]:checked');

                if (competencias.length === 0) {
                    event.preventDefault();
                    alert('Selecione pelo menos uma competência.');
                }
            });

            mostrarFormularioEmpresa.addEventListener('click', function () {
                formEmpresa.removeAttribute('hidden');
                mostrarFormularioEmpresa.setAttribute('hidden', 'true');
                mostrarFormularioCandidato.setAttribute('hidden', 'true');
            });

            mostrarFormularioCandidato.addEventListener('click', function () {
                formCandidato.removeAttribute('hidden');
                mostrarFormularioEmpresa.setAttribute('hidden', 'true');
                mostrarFormularioCandidato.setAttribute('hidden', 'true');
            });
        }

    }
}