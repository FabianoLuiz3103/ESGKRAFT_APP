function updateCliente() {
    // Remova qualquer mensagem de erro anterior
    document.getElementById("mensagemErroIdade").textContent = "";
    document.getElementById("mensagemErroEmail").textContent = "";
    document.getElementById("mensagemErroTelefone").textContent = "";

    // Captura o valor do campo "idCliente"
    var idCliente = document.getElementById("idCliente").value.toUpperCase();

    // Certifique-se de que o campo não esteja vazio
    if (!idCliente) {
        return true; // Permite o envio do formulário
    }

    const url = "/SprintFinal/atualizarCliente?idCliente=" + idCliente;

    $.ajax({
        type: 'GET',
        url: url,
        dataType: 'json',
        success: function(data) {
            console.log("Dados recebidos:", data);

            if (data.idCliente === idCliente) {
                document.getElementById("nomeCliente").textContent = data.nome;
                document.getElementById("idadeCliente").textContent = data.idade;
                document.getElementById("emailCliente").textContent = data.email;
                document.getElementById("telefoneCliente").textContent = data.telefone;

                document.getElementById("nomeClienteEdit").value = data.nome;
                document.getElementById("idadeClienteEdit").value = data.idade;
                document.getElementById("emailClienteEdit").value = data.email;
                document.getElementById("telefoneClienteEdit").value = data.telefone;

                document.getElementById("dadosCliente").style.display = "block";
                document.getElementById("loginForm").style.display = "none";
            } else {
                // Exibir mensagens de erro abaixo dos campos inválidos no modal
              
                    document.getElementById("mensagemErroIdade").textContent = data.errorMensagem;
                
                if (data.erroEmail) {
                    document.getElementById("mensagemErroEmail").textContent = data.erroEmail;
                }
                if (data.erroTelefone) {
                    document.getElementById("mensagemErroTelefone").textContent = data.erroTelefone;
                }

                $('#clienteModal').modal({ backdrop: 'static', keyboard: false });
            }
        },
        error: function(jqXHR, textStatus, errorThrown) {
            alert('O CLIENTE NÃO EXISTE!');
        }
    });
}


function updateValid() {
    // Remova qualquer mensagem de erro anterior
    document.getElementById("mensagemErroIdade").textContent = "";
    document.getElementById("mensagemErroEmail").textContent = "";
    document.getElementById("mensagemErroTelefone").textContent = "";

    // Captura o valor do campo "idCliente"
    var idCliente = document.getElementById("idCliente").value.toUpperCase();
    var idadeInserida = document.getElementById("idadeClienteEdit").value;
    var emailInserido = document.getElementById("emailClienteEdit").value;
    var telefoneInseriod = document.getElementById("telefoneClienteEdit").value;
    

    // Certifique-se de que o campo não esteja vazio
    if (!idCliente) {
        return true; // Permite o envio do formulário
    }

    const url = "/SprintFinal/validarUpdate?idCliente=" + idCliente;

    $.ajax({
        type: 'GET',
        url: url,
        dataType: 'json',
        success: function(data) {
            console.log("Dados recebidos:", data);
            const listaClientes = data.listaClientes;
            var emailExiste = false;
            var telefoneExiste = false;
            var emEx = false;
            var telEx = false;
            var em;
            var tel;
            listaClientes.forEach(function(cliente) {
                // Acesse as propriedades do cliente aqui
                console.log("ID do Cliente:", cliente.id);
                console.log("Nome do Cliente:", cliente.nome);
                console.log("Email do Cliente:", cliente.email);
                if(cliente.email === emailInserido) {
                    emailExiste = true;
                }
                if(cliente.telefone === telefoneInseriod){
                    telefoneExiste = true;
                }
                
                if(cliente.id === idCliente){
                    em = cliente.email
                }
                if(em === emailInserido){
                    emEx = true;
                }
                if(cliente.id === idCliente){
                    tel = cliente.telefone
                }
                if(tel === telefoneInserido){
                    telEx = true;
                }
                
            });
            
            if(emailExiste){
                   document.getElementById("mensagemErroEmail").textContent = "O EMAIL JÁ EXISTE";
            }
        },
        error: function(jqXHR, textStatus, errorThrown) {
            alert('O CLIENTE NÃO EXISTE!');
            $('#clienteModal').modal('show');
        }
    });
}
