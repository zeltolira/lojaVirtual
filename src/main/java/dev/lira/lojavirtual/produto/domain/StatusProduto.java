package dev.lira.lojavirtual.produto.domain;

public enum StatusProduto {

    EM_ESTOQUE{
        @Override
        public boolean podeSerVendido(){
            return true;
        }
        @Override
        public String getStatus(){
            return "O produto está em estoque e pode ser vendido";
        }
    },

    FORA_DE_ESTOQUE{
        @Override
        public boolean podeSerVendido(){
            return false;
        }

        @Override
        public String getStatus(){
            return "Produto inexistente no estoque, não pode ser vendido";
        }
    };

    public abstract boolean podeSerVendido();

    public abstract String getStatus();
}
