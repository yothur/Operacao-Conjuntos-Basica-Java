import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Double> conjuntoA = new ArrayList<>();
        ArrayList<Double> conjuntoB = new ArrayList<>();

        while (true){
            conjuntoA.clear();
            conjuntoB.clear();
            try {
                System.out.print("\nDigite quantos elementos você quer para o conjunto A: ");

                int quantA = sc.nextInt();

                if (quantA > 0) {
                    for (int i = 0; i < quantA ; i++) {
                        System.out.printf("Digite o %dº valor: ", i + 1);
                        double valor = sc.nextDouble();
                        conjuntoA.add(valor);

                    }

                    for (int i = 0; i < conjuntoA.size(); i++) {
                        for (int j = i + 1; j < conjuntoA.size(); j++) {
                            if (conjuntoA.get(i).equals(conjuntoA.get(j))) {
                                conjuntoA.remove(j);
                                j--;
                            }
                        }
                    }
                } else {
                    System.out.println("Digite uma quantidade maior que 0");
                    continue;
                }

                System.out.println("\nConjunto A: \n");

                System.out.println(conjuntoA);

                System.out.println();

                System.out.print("\nDigite quantos elementos você quer para o conjunto B: ");

                int quantB = sc.nextInt();

                if (quantB > 0) {
                    for (int i = 0; i < quantB ; i++) {
                        System.out.printf("Digite o %dº valor: ", i + 1);
                        double valor = sc.nextDouble();
                        conjuntoB.add(valor);

                    }

                    for (int i = 0; i < conjuntoB.size(); i++) {
                        for (int j = i + 1; j < conjuntoB.size(); j++) {
                            if (conjuntoB.get(i).equals(conjuntoB.get(j))) {
                                conjuntoB.remove(j);
                                j--;
                            }
                        }
                    }
                } else {
                    System.out.println("Digite uma quantidade maior que 0");
                    continue;
                }


                System.out.println("\nConjunto B: \n");

                System.out.println(conjuntoB);

                System.out.println();

                while (true){
                    try {
                        System.out.println("\nO que você deseja ver entre eles?: \n" +
                                "\n[1] - Intersecção\n" +
                                "[2] - União\n" +
                                "[3] - Diferença\n");

                        int op = sc.nextInt();

                        switch (op) {
                            case 1 -> {
                                TreeSet<Double> interseccao = new TreeSet<>();
                                for (int i = 0; i < conjuntoA.size(); i++) {
                                    for (int j = 0; j < conjuntoB.size(); j++) {
                                        if (conjuntoA.get(i).equals(conjuntoB.get(j))){
                                            interseccao.add(conjuntoA.get(i));
                                        }
                                    }
                                }
                                System.out.println("A Intersecção é: " + interseccao);
                            }
                            case 2 -> {
                                TreeSet<Double> uniao = new TreeSet<>();
                                uniao.addAll(conjuntoA);
                                uniao.addAll(conjuntoB);
                                System.out.println("A União é: " + uniao);
                            }
                            case 3 -> {
                                System.out.println("\nDiferença entre:\n" +
                                        "[1]- A-B\n" +
                                        "[2]- B-A\n");
                                int op2 = sc.nextInt();
                                switch (op2){
                                    case 1 ->{
                                        Set<Double> diferencaAB = new HashSet<>(conjuntoA);
                                        diferencaAB.removeAll(conjuntoB);
                                        System.out.println("A Diferença entre A e B é: " + diferencaAB);

                                    }
                                    case 2 -> {
                                        Set<Double> diferencaBA = new HashSet<>(conjuntoB);
                                        diferencaBA.removeAll(conjuntoA);
                                        System.out.println("A Diferença entre B e A é: "+ diferencaBA);
                                    }
                                    default -> System.out.println("Valor Invalido!");
                                }
                            }
                            default -> System.out.println("Valor Invalido!");
                        }

                        System.out.println("Deseja efetuar outras operações? [S/N]: ");

                        String op3 = sc.next().toUpperCase();

                        if (op3.equals("N") || op3.equals("NÃO") || op3.equals("NAO")){
                            System.out.println("Até outra hora!");
                            break;
                        }
                    }catch (Exception e){
                        System.err.println("Valor Invalido!");
                        sc.next();
                    }
                }
                System.out.println("Deseja testar outros conjuntos? [S/N]: ");
                String op4 = sc.next().toUpperCase();

                if (op4.equals("N") || op4.equals("NÃO") || op4.equals("NAO")){
                    System.out.println("Fim do código!");
                    break;
                }
            }catch (Exception e){
                System.err.println("Valor Invalido!");
                sc.next();
            }
        }
    }
}
