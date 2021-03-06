package sistema.telas;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import sistema.BancoDeDados;
import sistema.entidades.Cargo;

public class CargosInserir extends JPanel{
    
    JLabel labelTitulo, labelCargo;
    JTextField campoCargo;
    JButton botaoGravar;
    
    public CargosInserir(){
        criarComponentes();
        criarEventos(); 
    }
    
    public void criarComponentes(){
        setLayout(null);
        
        labelTitulo = new JLabel("Cadastro de Cargos", JLabel.CENTER);
        labelTitulo.setFont(new Font(labelTitulo.getFont().getName(), Font.PLAIN, 20));
        labelCargo = new JLabel("Nome do cargo", JLabel.LEFT);
        campoCargo = new JTextField();
        botaoGravar = new JButton("Adicionar Cargo");
        
        labelTitulo.setBounds(20, 20, 660, 40);
        labelCargo.setBounds(150, 120, 400, 20);
        campoCargo.setBounds(150, 140, 400,40);
        botaoGravar.setBounds(250, 380, 200, 40);
        
        add(labelTitulo);
        add(labelCargo);
        add(campoCargo);
        add(botaoGravar);
        
        setVisible(true);
    }
    
    public void criarEventos(){
        botaoGravar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Cargo novoCargo = new Cargo();
                novoCargo.setNome(campoCargo.getText());
                    
                sqlInserirCargo(novoCargo);
            }
        });
    }
    
    public void sqlInserirCargo(Cargo novoCargo){
        
        //validando nome
        if(campoCargo.getText().length() <= 3){
            JOptionPane.showMessageDialog(null, "Por favor, preencha o campo corretamente.");
            return;
        }
        
        //Conexão com o banco de dados
        Connection conexao;
        
        //Instrucao SQL
        Statement instrucaoSQL;
        
        //Resultados
        ResultSet resultados;
        
        try{
            //Conectando ao banco de dados
            conexao = DriverManager.getConnection(BancoDeDados.stringDeConexao, BancoDeDados.usuario, BancoDeDados.senha);
            
            //Criando a instrução SQL
            instrucaoSQL = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            instrucaoSQL.executeUpdate("INSERT INTO cargos (nome) VALUES ('"+novoCargo.getNome()+"')"); 
            
            JOptionPane.showMessageDialog(null, "Cargo adicionado com sucesso!");
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao adicionar o cargo");
            Logger.getLogger(CargosInserir.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
