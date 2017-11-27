<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Locadora Automóveis</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
        <link rel="stylesheet" type="text/css" href="../css/bootstrap/bootstrap.min.css" />
        <link rel="stylesheet" type="text/css" href="../css/bootstrap/bootstrap-theme.css" />
        <link rel="stylesheet" type="text/css" href="../css/select2.min.css" />	
        <link rel="stylesheet" type="text/css" href="../css/style.css" />	
        <script src="../scripts/jquery-3.2.1.min.js"></script>
        <script src="../scripts/bootstrap/bootstrap.min.js"></script>
        <script src="../scripts/select2.min.js"></script>
        <script src="../scripts/locadora.js"></script>
        
    </head>
    <body>
        <?php
            require_once "sessao/sessao.php";
            if(sessaoUsuarioAtiva()){
                $usuario = usuarioLogado();
            ?>
                <div class="container-fluid">
                    <div id="cabecalho" class="row">
                        <div class="col-xs-3 col-md-4">
                            <span class="" />
                        </div>
                        <div class="col-xs-5 col-md-4">
                            <h1>LOCADORA AUTOMÓVEIS</h1>
                        </div>
                        <div class="col-xs-4 col-md-4">
                            <div class="usuario">		
                                <div class="btn-group">
                                    <button type="button" class="btn btn-default dropdown-toggle nomeUsuario" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        <?php echo $usuario[0]['nome'] ?>
                                        <span class="caret"></span>
                                    </button>
                                    <ul class="dropdown-menu menuUsuario">
                                        <li><button type="button" class="botaoConfigurar" data-toggle="modal" data-target="#modalNovaConta">Configurar Conta</button></li>
                                        <li><button type="button" class="botaoConfigurar" data-toggle="modal" data-target="#modalDeletarConta">Remover Conta</button></li>
                                        <li class="divider"></li>
                                        <form action="sessao/logout.php" METHOD="POST">
                                            <li><input class="botaoConfigurar" type="submit" value="Logout"></li>	                                            
                                        </form>
                                    </ul>
                                </div>
                            </div>
                        </div>			
                    </div>
                </div>
            <?php
            }else{
                header("Location: /trabalhogb/index.php");
            }
        ?>        

        <div class="modal fade" id="modalNovaConta" tabindex="-1" role="dialog" aria-labelledby="modalCadastroLogin" aria-hidden="true">
  			<div class="modal-dialog" role="document">
	    		<div class="modal-content">
	      			<div class="modal-header">
	        			<h5 class="modal-title" id="textoNovoCadastro">Editar usuário</h5>
	        			<button type="button" class="close" data-dismiss="modal" aria-label="Close">
	        				<span aria-hidden="true">&times;</span>
	        			</button>
	      			</div>
			      		<div class="modal-body">
                            <input type="hidden" id="idUsuarioEdicao" value="<?php echo $usuario[0]['idUsuario']?>"/>
                            <div class="form-group">
                                <label for="newUser-nome" class="col-form-label">Nome</Label>
                                <input type="text" class="form-control" id="newUser-nome" placeholder="Preencha o nome" value="<?php echo $usuario[0]['nome'] ?>"/>						
                            </div>
                            <div class="form-group">
                                <label for="newUser-login" class="col-form-label">Login</Label>
                                <input type="text" class="form-control" id="newUser-login" placeholder="Preencha o login" value="<?php echo $usuario[0]['login']?>"/>
                            </div>
                            <div class="form-group">
                                <label for="newUser-senha" class="col-form-label">Senha</Label>
                                <input type="password" class="form-control" id="newUser-senha" placeholder="Preencha a senha" value="<?php echo $usuario[0]['senha']?>" />
                                </div>
                                <div class="form-group">
                                <label for="newUser-tpUsuario" class="col-form-label">Tipo Usuário</Label>
                                <select id="newUser-tpUsuario" class="form-control">
                                    <option value="1" <?php echo $usuario[0]['idTipoUsuario'] == 1 ? 'selected' : '' ?> >Cliente</option>        
                                    <option value="2" <?php echo $usuario[0]['idTipoUsuario'] == 2 ? 'selected' : '' ?> >Funcionario</option>                            
                                </select>
                            </div>
			      		</div>
			      		<div class="modal-footer">
			        		<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                            <button type="button" class="btn btn-primary" data-dismiss="modal" onClick="cadastraNovoUsuario();">Cadastrar</button>
			      		</div>
	   			</div>
			</div>
		</div>

        <div class="modal fade" tabindex="-1" role="dialog" id="modalDeletarConta">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title">Confirmar remoção da conta</h4>
		      </div>
		      <div class="modal-body">
		        <p>Deseja realmente remover a conta do sistema? Não será possivel recuperar a conta.</p>
		      </div>
		      <div class="modal-footer">
                <button class="btn btn-danger" onclick="deletarUsuario();">Confirmar exclusão</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
		      </div>
		    </div>
		  </div>
		</div>

    </body>
</html>