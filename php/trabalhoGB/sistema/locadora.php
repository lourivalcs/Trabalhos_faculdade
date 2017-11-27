<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Locadora de automóveis</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
    </head>
    <body>
        <?php
            require_once "C:/xampp/htdocs/trabalhogb/cabecalho.php";
            require_once "sessao/sessao.php";
            require_once "dao/marcaDao.php";
            require_once "dao/veiculoDao.php";
            require_once "dao/usuarioDao.php";
            require_once "dao/aluguelDao.php";

            if(!sessaoUsuarioAtiva()){
                header("Location: /trabalhogb/index.php");
            }
            $marcas = BuscarTodasMarcas();
            $veiculos = BuscarTodosVeiculos();
            $veiculosParaAlugar = buscarVeiculosDisponiveis();
            $clientesDisponiveis = BuscarTodosUsuariosClientes();
            $alugueis = buscarAlugueis();            

        ?>

        <div id="menu-lateral" class="col-sm-2 col-md-2">
            <ul class="nav nav-pills nav-stacked">
                <li><a href="#" class="list-group-item" onClick="linksMenuLateral('veiculo');return false;">Veículo</a></li>
                <li><a href="#" class="list-group-item" onClick="linksMenuLateral('marca');return false;">Marca</a></li>
                <li><a href="#" class="list-group-item" onClick="linksMenuLateral('aluguel');return false;">Alugar</a></li>
                <li><a href="#" class="list-group-item" onClick="linksMenuLateral('csv');return false;">csv</a></li>
            </ul>
        </div>
        <div id="centro" class="col-sm-8 col-md-8">
            <div id="aluguel">
                <div class="form-group">
                    <input type="hidden" id="idAluguelSelecionado" value="0">
                    <span class="glyphicon glyphicon-search pesquisar" aria-hidden="true"></span>
                    <select id="aluguelCadastrados" class="select2" style="width: 50%" onchange="buscarAluguel();">
                        <option value="0">Selecione um aluguel</option>
                        <?php 
                            foreach($alugueis as $aluguel){
                                echo "<option value=".$aluguel[0].">".$aluguel[0]." - " .$aluguel[3]. " - " . $aluguel[4] . "</option>";
                            }
                        ?>
                    </select>
                    <a href="#" title="Adicionar Novo Aluguel" onClick="habilitarBotoesCadastroAluguel( false ); return false;"><span class="glyphicon glyphicon-plus btnAdicionar"></span></a>                    
                </div>

                <div class="form-group">
                    <label for="veiculosAluguel" class="control-label">Veículo</label>
                    <select id="veiculosAluguel" class="select2" style="width:100%" disabled>
                        <option value="0">Selecione uma placa</option>
                        <?php 
                            foreach($veiculosParaAlugar as $veiculo){
                                echo "<option value=".$veiculo[0].">".$veiculo[2]."</option>";
                            }
                        ?>
                    </select>
                </div>

                <div class="form-group">
                    <label for="clientesAluguel" class="control-label">Cliente</label>
                    <select id="clientesAluguel" class="select2" style="width:100%" disabled>
                        <option value="0">Selecione um cliente</option>
                        <?php 
                            foreach($clientesDisponiveis as $cliente){
                                echo "<option value=".$cliente[0].">".$cliente[2]."</option>";
                            }
                        ?>
                    </select>
                </div>

                <div class="form-group">
                    <label for="devolver" class="control-label">Devolver? </label>
                    <input type="checkbox" class="form-control" id="devolver" style="width: 3%;" disabled>
                </div>
                <div class="form-group">
                    <label for="dataAluguel" class="control-label">Data Alugado</label>
                    <input type="text" id="dataAluguel" class="form-control" disabled />
                </div>

                <div class="form-group">
                    <label for="dataDevolucao" class="control-label">Data Devolução</label>
                    <input type="text" id="dataDevolucao" class="form-control" disabled />
                </div>

                <div class="form-group botoes">
                    <button class="btn btn-danger" id="apagarAluguel" disabled onClick="deletarAluguel();">Remover Registro</button>
                    <button class="btn btn-default" id="cancelarAluguel" disabled onClick="habilitarBotoesCadastroAluguel( true );">Cancelar</button>
                    <button class="btn btn-primary" id="salvarAluguel" disabled onClick="salvarAluguel();">Salvar</button>
                </div>
            </div>

            <div id="veiculo">
                <div class="form-group">
                    <span class="glyphicon glyphicon-search pesquisar" aria-hidden="true"></span>
                    <select id="veiculosCadastrados" class="select2" style="width: 50%" onchange="buscarVeiculos();">
                        <option value="0">Selecione uma placa</option>
                        <?php 
                            foreach($veiculos as $veiculo){
                                echo "<option value=".$veiculo[0].">".$veiculo[2]."</option>";
                            }
                        ?>
                    </select>
                    <a href="#" title="Adicionar Novo veículo" onClick="habilitarBotoesCadastroVeiculo( false ); return false;"><span class="glyphicon glyphicon-plus btnAdicionar"></span></a>                    
                </div>

                <div class="form-group">
                    <label for="nomeMarca" class="control-label">Marca</label>
                    <select id="nomeMarca" class="form-control" disabled>
                        <option value="0" selected>Selecione a marca</option>
                        <?php 
                            foreach($marcas as $marca){
                                echo "<option value=".$marca[0].">".$marca[1]."</option>";
                            }
                        ?>
                    </select>
                </div>                       
                <div class="form-group">
                    <input type="hidden" id="idAutomovel" value="0">
                    <label for="placa" class="control-label">Placa</label>
                    <input type="text" id="placa" class="form-control" disabled/>
                </div>
                <div class="form-group">
                    <label for="valorAluguel" class="control-label">Valor aluguel</label>
                    <input type="text" id="valorAluguel" class="form-control" disabled/>
                </div>
                <div class="form-group botoes">
                    <button class="btn btn-danger" id="apagarVeiculo" disabled onClick="deletarVeiculo();">Remover</button>
                    <button class="btn btn-default" id="cancelar" disabled onClick="habilitarBotoesCadastroVeiculo( true );">Cancelar</button>
                    <button class="btn btn-primary" id="salvar" disabled onClick="cadastrarVeiculo();">Salvar</button>
                </div>
            </div>

            <div id="marca">
                <div class="form-group">
                    <span class="glyphicon glyphicon-search pesquisar" aria-hidden="true"></span>
                    <select id="marcasCadastradas" class="select2" style="width: 50%" onchange="buscarMarcas();">
                        <option value="0" selected>Selecione uma marca</option>
                            <?php 
                                foreach($marcas as $marca){
                                    echo "<option value=".$marca[0].">".$marca[1]."</option>";
                                }
                            ?>
                    </select>
                    <a href="#" title="Adicionar Nova Marca" onClick="habilitarBotoesCadastroMarca( false ); return false;"><span class="glyphicon glyphicon-plus btnAdicionar"></span></a>                    
                </div>
                <div class="form-group">
                    <input type="hidden" id="marcaEdicao" value="0" />
                    <label for="txtMarca" class="control-label">Marca</label>
                    <input type="text" id="txtMarca" class="form-control" disabled/>
                </div>
                <div class="form-group botoes">
                    <button class="btn btn-danger" id="apagarMarca" disabled onClick="deletarMarca();">Remover</button>
                    <button class="btn btn-default" id="cancelarMarca" disabled onClick="habilitarBotoesCadastroMarca( true );" >Cancelar</button>
                    <button class="btn btn-primary" id="salvarMarca" disabled onClick="cadastrarMarca();">Salvar</button>
                </div>
            </div>

            <div id="csv">
                <form action="dao/csvDao.php" method="post">
                    <div class="form-group">
                        <label for="gerarCSV" class="control-label">Escolha um csv para gerar</label>
                        <select name="selectCSV" id="gerarCSV" class="form-control">
                            <option value="0">Selecione uma opção</option>
                            <option value="1">Aluguel</option>
                            <option value="2">Automóveis</option>
                            <option value="3">Marca</option>
                            <option value="4">Usuario</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn btn-primary">Gerar CSV</button>
                    </div>
                </form>
            </div>
        </div>

        <div id="direita" class="col-sm-2 col-md-2">
            
        </div>
    </body>
</html>