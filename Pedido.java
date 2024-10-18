import java.util.ArrayList;

public class Pedido {
    private ArrayList<ItemDoPedido> itens;
    Mesa mesa;
    boolean finalizado;

    public Pedido(Mesa mesa){
        this.mesa = mesa;
        this.itens = new ArrayList<>();
        this.finalizado = false;
    }

    public void adicionarPedidos(ItemDoPedido item){
        if(!finalizado){ // finalizado != true
            itens.add(item);
        }
        else {
            System.out.println("O pedido ja foi finalizado, e não pode mais ser alterado");
        }
    }

    public double calcularTotal(){
        double total = 0.0;
        for(ItemDoPedido item : itens ){
            total += item.calcularTotal();
        }
        return total;
    }

    public  void fecharPedido(){
        if(!finalizado){
            finalizado = true;
            mesa.setDisponivel(true);
            System.out.println("Pedido Finalizado. Total a ser pago: R$ " + calcularTotal());
        }
    }

    @Override
    public String toString(){
        String detalhamento = "Pedido na mesa " + mesa.getNumero() + "\n";
        for(ItemDoPedido item : itens){
            detalhamento += item.toString() + "\n";
        }
        detalhamento += "Total R$ " + calcularTotal();
        return detalhamento;
    }



}
