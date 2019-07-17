package sistema;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import sistema.entidades.Cargo;
import sistema.telas.CargosConsultar;
import sistema.telas.CargosEditar;
import sistema.telas.CargosInserir;
import sistema.telas.FuncionariosInserir;
import sistema.telas.Inicio;
import sistema.telas.Login;

public class Navegador {
    
    private static boolean menuConstruido;
    private static boolean menuHabilitado;
    private static JMenuBar menuBar;
    private static JMenu menuArquivo, menuFuncionarios, menuCargos, menuRelatorios;
    private static JMenuItem miSair, miFuncionariosConsultar, miFuncionariosCadastrar, miCargosConsultar;
    private static JMenuItem miCargosCadastrar, miRelatoriosCargos, miRelatoriosSalarios;
    
    public static void login(){
        Sistema.tela = new Login();
        Sistema.frame.setTitle("Funcionários Company SA");
        Navegador.atualizarTela();
    }
    
    public static void inicio(){
        Sistema.tela = new Inicio();
        Sistema.frame.setTitle("Funcionários Company SA");
        Navegador.atualizarTela();
    }
    
    public static void cargosCadastrar(){
        Sistema.tela = new CargosInserir();
        Sistema.frame.setTitle("Funcionários Company SA - Cadastrar cargos");
        Navegador.atualizarTela();
    }
    
    public static void cargosConsultar(){
        Sistema.tela = new CargosConsultar();
        Sistema.frame.setTitle("Funcionários Company SA - Consultar cargos");
        Navegador.atualizarTela();
    }
    
    public static void cargosEditar(Cargo cargo){
        Sistema.tela = new CargosEditar(cargo);
        Sistema.frame.setTitle("Funcionários Company SA - Editar cargos");
        Navegador.atualizarTela();
    }
    
    public static void funcionariosCadastrar(){
        Sistema.tela = new FuncionariosInserir();
        Sistema.frame.setTitle("Funcionários Company SA - Cadastrar funcionários");
        Navegador.atualizarTela();
    }
    
    public static void funcionariosConsultar(){
        Sistema.tela = new CargosConsultar();
        Sistema.frame.setTitle("Funcionários Company SA - Consultar funcionários");
        Navegador.atualizarTela();
    }
    
    public static void funcionariosEditar(Cargo cargo){
        Sistema.tela = new CargosEditar(cargo);
        Sistema.frame.setTitle("Funcionários Company SA - Editar funcionários");
        Navegador.atualizarTela();
    }
    
    private static void atualizarTela(){
        Sistema.frame.getContentPane().removeAll();
        Sistema.tela.setVisible(true);
        Sistema.frame.add(Sistema.tela);
        
        Sistema.frame.setVisible(true);
    }
    
    private static void construirMenu(){
        if(!menuConstruido){
            menuConstruido = true;
            
            menuBar = new JMenuBar();
            
            //menu arquivo
            menuArquivo = new JMenu("Arquivo");
            menuBar.add(menuArquivo);
            miSair = new JMenuItem("Sair");
            menuArquivo.add(miSair);
            
            //menu Funcionarios
            menuFuncionarios = new JMenu("Funcionários");
            menuBar.add(menuFuncionarios);
            miFuncionariosCadastrar = new JMenuItem("Cadastrar");
            menuFuncionarios.add(miFuncionariosCadastrar);
            miFuncionariosConsultar = new JMenuItem("Consultar");
            menuFuncionarios.add(miFuncionariosConsultar);
            
            //menu Cargos
            menuCargos = new JMenu("Cargos");
            menuBar.add(menuCargos);
            miCargosCadastrar = new JMenuItem("Cadastrar");
            menuCargos.add(miCargosCadastrar);
            miCargosConsultar = new JMenuItem("Consultar");
            menuCargos.add(miCargosConsultar);
            
            //menu Relatórios
            menuRelatorios = new JMenu("Relatórios");
            menuBar.add(menuRelatorios);
            miRelatoriosCargos = new JMenuItem("Funcionários por cargo");
            menuRelatorios.add(miRelatoriosCargos);
            miRelatoriosSalarios = new JMenuItem("Salários dos funcionários");
            menuRelatorios.add(miRelatoriosSalarios);
            
            criarEventosMenu();
        }
    }
    
    public static void habilitaMenu(){
        if(!menuConstruido) construirMenu();
        if(!menuHabilitado){
            menuHabilitado = true;
            Sistema.frame.setJMenuBar(menuBar);
        }
    }
    
    public static void desabilitaMenu(){
        if(!menuHabilitado){
            menuHabilitado = false;
            Sistema.frame.setJMenuBar(null);
        }
    }
    
    private static void criarEventosMenu(){
        miSair.addActionListener(new ActionListener (){
            @Override
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
        
        //Funcionário
        miFuncionariosCadastrar.addActionListener(new ActionListener (){
            @Override
            public void actionPerformed(ActionEvent e){
                funcionariosCadastrar();
            }
        });
        
        //Consultar
        miFuncionariosConsultar.addActionListener(new ActionListener (){
            @Override
            public void actionPerformed(ActionEvent e){
            }
        });
        
        //Cargos
        miCargosCadastrar.addActionListener(new ActionListener (){
            @Override
            public void actionPerformed(ActionEvent e){
                cargosCadastrar();
            }
        });
        
        //Consultar
        miCargosConsultar.addActionListener(new ActionListener (){
            @Override
            public void actionPerformed(ActionEvent e){
                cargosConsultar();
            }
        });
        
        //Relatórios Cargos
        miRelatoriosCargos.addActionListener(new ActionListener (){
            @Override
            public void actionPerformed(ActionEvent e){
            }
        });
        
        //Relatorios Salarios
        miRelatoriosSalarios.addActionListener(new ActionListener (){
            @Override
            public void actionPerformed(ActionEvent e){
            }
        });
        
        
    }
    
    
    
}
