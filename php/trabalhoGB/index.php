<html>
<head>
    <title>Locadora de automóveis</title>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<link rel="stylesheet" type="text/css" href="css/bootstrap/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="css/bootstrap/bootstrap-theme.css" />
	<link rel="stylesheet" type="text/css" href="css/select2.min.css" />	
	<link rel="stylesheet" type="text/css" href="css/style.css" />	
	<script src="scripts/jquery-3.2.1.min.js"></script>
	<script src="scripts/bootstrap/bootstrap.min.js"></script>
	<script src="scripts/select2.min.js"></script>
    <script src="scripts/locadora.js"></script>
</head>

<body>
    <div class="container-fluid">
        <div class="row topo">
            <div class="col-xs-12 col-md-12"></div>
        </div>
        <div class="row">
            <div class="col-xs-4 col-md-4"></div>
            <div class="col-xs-4 col-md-4">
                <form action="sistema/sessao/login.php" method="POST">
                    <div class="form-group">
                        <div class="row">
                            <label for="login">Login:</Label>
                            <input type="text" class="form-control" id="login" name="login" />
                        </div>
                        <div class="row">
                            <label for="senha">Senha:</Label>
                            <input type="password" class="form-control" id="senha" name="senha" />
                        </div>
                    </div>
                    <div class="row">
                        <input type="submit" class="btn btn-primary" value="Logar">
                        <button type="button" class="btn btn-default novaConta" data-toggle="modal" data-target="#modalNovaConta">Novo Cadastro</button>
                    </div>
                </form>
            </div>
            <div class="col-xs-4 col-md-4"></div>
        </div>
        <div class="row">
            <div class="col-xs-12 col-md-12"></div>
        </div>

        <div class="modal fade" id="modalNovaConta" tabindex="-1" role="dialog" aria-labelledby="modalCadastroLogin" aria-hidden="true">
  			<div class="modal-dialog" role="document">
	    		<div class="modal-content">
	      			<div class="modal-header">
	        			<h5 class="modal-title" id="textoNovoCadastro">Cadastro novo usuário</h5>
	        			<button type="button" class="close" data-dismiss="modal" aria-label="Close">
	        				<span aria-hidden="true">&times;</span>
	        			</button>
	      			</div>
			      		<div class="modal-body">
                            <input type="hidden" id="idUsuarioEdicao" value="0"/>
                            <div class="form-group">
                                <label for="newUser-nome" class="col-form-label">Nome</Label>
                                <input type="text" class="form-control" id="newUser-nome" placeholder="Preencha o nome" />						
                            </div>
                            <div class="form-group">
                                <label for="newUser-login" class="col-form-label">Login</Label>
                                <input type="text" class="form-control" id="newUser-login" placeholder="Preencha o login" />
                            </div>
                            <div class="form-group">
                                <label for="newUser-senha" class="col-form-label">Senha</Label>
                                <input type="password" class="form-control" id="newUser-senha" placeholder="Preencha a senha" />
                                </div>
                                <div class="form-group">
                                <label for="newUser-tpUsuario" class="col-form-label">Tipo Usuário</Label>
                                <select id="newUser-tpUsuario" class="form-control">
                                    <option value="1">Cliente</option>        
                                    <option value="2" selected>Funcionario</option>                            
                                </select>
                            </div>
			      		</div>
			      		<div class="modal-footer">
			        		<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                            <button type="button" class="btn btn-primary" data-dismiss="modal" onClick="cadastraNovoUsuario('index');">Cadastrar</button>
			      		</div>
	   			</div>
			</div>
		</div>
    </div>
</body>
</html>