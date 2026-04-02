import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class vendasVIEW extends javax.swing.JFrame {

    public vendasVIEW() {
        initComponents();
        listarVendidos();
    }

    private javax.swing.JTable tabelaVendas;
    private javax.swing.JScrollPane scroll;

    private void initComponents() {

        tabelaVendas = new javax.swing.JTable();
        scroll = new javax.swing.JScrollPane();

        setTitle("Produtos Vendidos");

        tabelaVendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {"ID", "Nome", "Valor", "Status"}
        ));

        scroll.setViewportView(tabelaVendas);

        add(scroll);

        setSize(500, 300);
        setLocationRelativeTo(null);
    }

    private void listarVendidos() {
        try {
            ProdutosDAO dao = new ProdutosDAO();

            DefaultTableModel model = (DefaultTableModel) tabelaVendas.getModel();
            model.setNumRows(0);

            ArrayList<ProdutosDTO> lista = dao.listarProdutosVendidos();

            for (int i = 0; i < lista.size(); i++) {
                model.addRow(new Object[]{
                    lista.get(i).getId(),
                    lista.get(i).getNome(),
                    lista.get(i).getValor(),
                    lista.get(i).getStatus()
                });
            }

        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }
}