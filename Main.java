import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Mesa> mesas = new ArrayList<>();
        ArrayList<Pedido> pedidos = new ArrayList<>();

        mesas.add(new Mesa(1));
        mesas.add(new Mesa(2));

        registrarPedido(mesas, pedidos, 1, new ItemDoPedido("Hamburguer", 2, 25.00));
        registrarPedido(mesas, pedidos, 1, new ItemDoPedido("Batata Frita", 1, 10.00));
        registrarPedido(mesas, pedidos, 2, new ItemDoPedido("Refrigerante", 3, 5.00));

        fecharPedido(pedidos, 1);
        fecharPedido(pedidos, 2);

        gerarRelatorioVendas(pedidos);
    }

    public static Mesa buscarMesa(ArrayList<Mesa> mesas, int numeroMesa) {
        for (Mesa mesa : mesas) {
            if (mesa.getNumero() == numeroMesa && mesa.isDisponivel()) {
                return mesa;
            }
        }
        return null;
    }

    public static void registrarPedido(ArrayList<Mesa> mesas, ArrayList<Pedido> pedidos, int numeroMesa, ItemDoPedido item) {
        Pedido pedidoAtual = null;
        for (Pedido pedido : pedidos) {
            if (pedido.mesa.getNumero() == numeroMesa && !pedido.finalizado) {
                pedidoAtual = pedido;
                break;
            }
        }

        if (pedidoAtual == null) {
            Mesa mesa = buscarMesa(mesas, numeroMesa);
            if (mesa != null) {
                mesa.setDisponivel(false);
                pedidoAtual = new Pedido(mesa);
                pedidos.add(pedidoAtual);
                System.out.println("Novo pedido iniciado na mesa " + numeroMesa);
            } else {
                System.out.println("Mesa " + numeroMesa + " não está disponível.");
                return;
            }
        }

        pedidoAtual.adicionarPedidos(item);
        System.out.println("Item adicionado ao pedido: " + item);
    }

    public static void fecharPedido(ArrayList<Pedido> pedidos, int numeroMesa) {
        for (Pedido pedido : pedidos) {
            if (pedido.mesa.getNumero() == numeroMesa && !pedido.finalizado) {
                pedido.fecharPedido();
                return;
            }
        }
        System.out.println("Não foi encontrado nenhum pedido aberto para a mesa " + numeroMesa);
    }

    public static void gerarRelatorioVendas(ArrayList<Pedido> pedidos) {
        System.out.println("Relatório de Vendas\n");
        if (pedidos.isEmpty()) {
            System.out.println("Nenhuma venda realizada.");
        } else {
            double totalVendas = 0;
            for (Pedido pedido : pedidos) {
                System.out.println(pedido);
                totalVendas += pedido.calcularTotal();
            }
            System.out.println("Total geral de vendas: R$ " + totalVendas);
        }
    }
}
