    package com.example.software_sociais.controllers;

    import com.example.software_sociais.controllers.Utilities.Alerta;
    import com.example.software_sociais.controllers.Utilities.Atualizar;
    import com.example.software_sociais.controllers.Utilities.Navegador;
    import com.example.software_sociais.database.vendas_DAO;
    import com.example.software_sociais.objects.Evento;
    import com.example.software_sociais.objects.Venda;
    import javafx.event.ActionEvent;
    import javafx.fxml.FXML;
    import javafx.fxml.Initializable;
    import javafx.scene.Node;
    import javafx.scene.control.*;
    import javafx.scene.control.cell.PropertyValueFactory;
    import javafx.stage.Stage;

    import java.io.IOException;
    import java.net.URL;

    import java.util.ResourceBundle;

    public class init_vendasController implements Initializable {

        @FXML
        private TableColumn<Venda, String> colProduto;

        @FXML
        private TableColumn<Venda, Double> colValor;

        @FXML
        private Label lbl_titulo;

        @FXML
        private TableView<Venda> tabelaVendas;

        @FXML
        private TextField txt_vendaProduto;

        @FXML
        private TextField txt_vendaValor;

        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {
            //Coloca nome do evento no titulo
            lbl_titulo.setText("Evento - " + Navegador.evento.getNome());

            //Inicializa as colunas
            colProduto.setCellValueFactory(new PropertyValueFactory<>("produto"));
            colValor.setCellValueFactory(new PropertyValueFactory<>("valor"));

            //atualiza as colunas
            vendas_DAO DAO = new vendas_DAO();
            Atualizar.AtualizarTabela(tabelaVendas, DAO.listar_toEvento(Navegador.evento.getId()));
        }

        @FXML
        void clickRealizarVenda(ActionEvent event) {
            //Efeito de pisca
            Atualizar.piscaBotao((Button) event.getSource());
            //-----------------------------------
            Venda venda = new Venda();
            //Se o valor da venda ou o nome do produto não estiver preenchido não realiza a venda
            if (txt_vendaProduto.getText().isBlank() || txt_vendaValor.getText().isBlank()){
                Alerta.alerta("Campos não preenchidos",
                        "Preencha todos os campos para realizar a venda",
                        Alert.AlertType.ERROR);
                return;
            }
            //Se estiver tudo OK cadastra a venda
            //  Registra o ID do evento
            if(Navegador.evento == null){
                System.err.println("Evento está nulo!!!");
            }else {
                venda.setId_evento(Navegador.evento.getId());
            }
            //  Registra o nome do produto
            venda.setProduto(txt_vendaProduto.getText());
            //  Registra o valor da venda
            venda.setValor(Double.parseDouble(txt_vendaValor.getText()));

            //Insere a venda no BD
            vendas_DAO DAO = new vendas_DAO();
            DAO.insert(venda);

            //Atualiza tabela
            Atualizar.AtualizarTabela(tabelaVendas, DAO.listar_toEvento(Navegador.evento.getId()));
        }

        @FXML
        void clickVoltar(ActionEvent event) {
            //Varivel do navegador fica null
            Navegador.evento = null;
            //Volta a pagina
            try {
                Navegador.returnPage((Stage) ((Node) event.getSource()).getScene().getWindow());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
