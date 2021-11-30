package ficha04.Ex2;

import java.util.Objects;

public class CoffeeExpresso extends Coffee{

    public CoffeeExpresso(String tipo) {
        this.nome = "café expresso";
        this.temperatura = 70;
        switch (tipo) {
            case "curto" -> this.quantidade = 25;
            case "normal" -> this.quantidade = 35;
            case "cheio" -> this.quantidade = 50;
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
