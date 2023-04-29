package com.mycompany.bancojava2;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class Bancojava2 {

    static Scanner t = new Scanner(System.in);
    static Scanner t2 = new Scanner(System.in);
   

    public static String[] cad(){

        String aux[] = new String[3];
        int op = 0;
        aux[0] = JOptionPane.showInputDialog(null, "Informe o seu nome", "cadastro", JOptionPane.QUESTION_MESSAGE);
        while (op != 2) {
            aux[1] = JOptionPane.showInputDialog(null, "Informe o numero do seu celular", "cadastro", JOptionPane.QUESTION_MESSAGE);
            if (aux[1].length() != 9) {
                JOptionPane.showMessageDialog(null, "ERRO!\nInforme um numero de celular valido", "cadastro", JOptionPane.WARNING_MESSAGE);
            } else {
                op = 2;
            }
        }
        while (op != 1) {
            aux[2] = JOptionPane.showInputDialog(null, "Informe seu Cpf", "cadastro", JOptionPane.QUESTION_MESSAGE);
            if (aux[2].length() != 11) {
                JOptionPane.showMessageDialog(null, "ERRO!\nInforme um cpf valido", "cadastro", JOptionPane.WARNING_MESSAGE);
            } else {
                op = 1;
            }
        }
        return aux;
    }

    public static String trocacel(String[] cel) {

        String novocel[] = new String[10];

        novocel[0] = JOptionPane.showInputDialog(null, "Informe o novo numero de celular", "Alterar", JOptionPane.QUESTION_MESSAGE);

        return novocel[0];
    }

    public static int buscaruser(String[] name) {
        String aux;
        int i = 0;

        aux = JOptionPane.showInputDialog(null,"Informe o nome do usuario que procura", "Alterar celular", JOptionPane.QUESTION_MESSAGE);
        for (i = 0; i < name.length; i++) {
            if (aux.equals(name[i])) {
                return i;
            }
        }
        return 15;
    }

    public static int buscarcpf(String[] cpf) {
        int i = 0;
        String aux;

        aux = JOptionPane.showInputDialog(null,"Informe o cpf do usuario que procura", "Deposito", JOptionPane.QUESTION_MESSAGE);
        for (i = 0; i < cpf.length; i++) {
            if (aux.equals(cpf[i])) {
                return i;
            }
        }
        return 99;
    }

    public static float cred(float[] credito) {
        float aux = 0;
        String input;
        int i = 0;
        input = JOptionPane.showInputDialog(null,"Informe quanto deseja depositar:", "Deposito", JOptionPane.QUESTION_MESSAGE);
        aux = Float.parseFloat(input);
        credito[i] += aux;
        return credito[i];
    }

    public static void main(String[] args) {
        int opcao = 0, op = 0, i = 0, pos = 0;
        float saldo[] = new float[10];
        float debito[] = new float[10];
        float credito[] = new float[10];
        String input;
        String dados[] = new String[10];
        String name[] = new String[10];
        String cpf[] = new String[10];
        String cel[] = new String[10];

        JOptionPane.showMessageDialog(null, "Bem vindo ao Banco DR");
        while (opcao != 7) {

            input = JOptionPane.showInputDialog(null, "Qual funçao deseja realizar\n1-Cadastro de usuario\n2-Credito\n3-Debito\n4-Atualizar conta(apenas cel)\n5-Verificar usuario\n6-Verificar saldo\n7-Sair", "Banco DR", JOptionPane.QUESTION_MESSAGE);
            opcao = Integer.parseInt(input);

            switch (opcao) {
                case 1 -> {

                    if (i == 10) {
                        JOptionPane.showMessageDialog(null,"limite de usuarios cadastrados","cadastro", JOptionPane.QUESTION_MESSAGE);
                    } else {
                        dados = cad();
                        name[i] = dados[0];
                        cel[i] = dados[1];
                        cpf[i] = dados[2];
                        i++;
                    }
                }
                case 2 -> {
                    input = JOptionPane.showInputDialog(null,"Como deseja procurar o usuario\n1-nome\n2-cpf","Deposito", JOptionPane.QUESTION_MESSAGE);
                    op = Integer.parseInt(input);
                    switch (op) {
                        case 1 -> {
                            pos = buscaruser(name);
                            if (pos == 15) {
                                JOptionPane.showMessageDialog(null,"Usuario não encontrado!", "Deposito", JOptionPane.WARNING_MESSAGE);
                            } else{
                                saldo[pos] = cred(credito);
                            }
                        }
                        case 2 -> {
                            pos = buscarcpf(cpf);
                            if (pos == 99) {
                                JOptionPane.showInputDialog(null,"Usuario nao encontrado!", "Deposito", JOptionPane.WARNING_MESSAGE);
                            } else {
                                saldo[pos] = cred(credito);
                            }
                        }
                    }
                }
                case 3 -> {
                    input = JOptionPane.showInputDialog(null,"Como deseja procurar o usuario\n1-nome\n2-cpf", "Saque", JOptionPane.QUESTION_MESSAGE);
                    op = Integer.parseInt(input);
                    switch (op) {
                        case 1 -> {
                            pos = buscaruser(name);
                            if (pos == 15) {
                                JOptionPane.showMessageDialog(null,"Usuario não encontrado!", "Saque", JOptionPane.WARNING_MESSAGE);
                            } else {
                                input = JOptionPane.showInputDialog(null,"Informe quanto deseja Sacar:", "Saque", JOptionPane.WARNING_MESSAGE);
                                debito[pos] = Float.parseFloat(input);
                                if (saldo[pos] < debito[pos]) {
                                    JOptionPane.showMessageDialog(null,"Saldo insuficiente", "Saque",JOptionPane.QUESTION_MESSAGE);
                                } else {
                                    saldo[pos] = saldo[pos] - debito[pos];
                                }
                            }
                        }
                        case 2 -> {
                            pos = buscarcpf(cpf);
                            if (pos == 99) {
                                JOptionPane.showMessageDialog(null,"Usuario nao encontrado!", "Saque", JOptionPane.WARNING_MESSAGE);
                            } else {
                                input = JOptionPane.showInputDialog(null,"Informe quanto deseja Sacar:", "Saque", JOptionPane.QUESTION_MESSAGE);
                                debito[pos] = Float.parseFloat(input);
                                if (saldo[pos] < debito[pos]) {
                                    JOptionPane.showMessageDialog(null,"Saldo insuficiente", "Saque", JOptionPane.WARNING_MESSAGE);
                                } else {
                                    saldo[pos] = saldo[pos] - debito[pos];
                                }
                            }
                        }
                    }
                }
                case 4 -> {
                    input = JOptionPane.showInputDialog(null,"Como deseja procurar o usuario\n1-nome\n2-cpf","Alterar celular", JOptionPane.QUESTION_MESSAGE);
                    op = Integer.parseInt(input);
                    switch (op) {
                        case 1 -> {
                            pos = buscaruser(name);
                            if (pos == 15) {
                                JOptionPane.showMessageDialog(null,"Usuario não encontrado!", "Alterar celular", JOptionPane.WARNING_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null,"nome: " + name[pos] + "\nCpf: " + cpf[pos] + "\nCel: " + cel[pos]);
                                cel[pos] = trocacel(cel);
                                JOptionPane.showMessageDialog(null,"novo numero de celular: " + cel[pos]);
                            }
                        }
                        case 2 -> {
                            pos = buscarcpf(cpf);
                            if (pos == 99) {
                                JOptionPane.showInputDialog(null,"Usuario nao encontrado!", "Alterar celular", JOptionPane.WARNING_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null,"nome: " + name[pos] + "\nCpf: " + cpf[pos] + "\nCel: " + cel[pos]);
                                cel[pos] = trocacel(cel);
                                JOptionPane.showMessageDialog(null,"novo numero de celular: " + cel[pos]);
                            }
                        }
                    }
                }
                case 5 -> {
                    input = JOptionPane.showInputDialog("Como deseja procurar o usuario\n1-nome\n2-cpf:");
                    op = Integer.parseInt(input);
                    switch (op) {
                        case 1 -> {
                            pos = buscaruser(name);
                            if (pos == 15) {
                                JOptionPane.showMessageDialog(null,"Usuario não encontrado!", "Verificar Usuario", JOptionPane.WARNING_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null,"Nome: " + name[pos]+ "\nCpf: " + cpf[pos] + "\nCel: " + cel[pos]);
                            }
                        }
                        case 2 -> {
                            pos = buscarcpf(cpf);
                            if (pos == 99) {
                                JOptionPane.showMessageDialog(null,"Usuario nao encontrado!", "Verificar Usuario", JOptionPane.WARNING_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null,"Nome: " + name[pos]+ "\nCpf: " + cpf[pos] + "\nCel: " + cel[pos]);
                            }
                        }
                    }
                }
                case 6 -> {
                    input = JOptionPane.showInputDialog(null,"Como deseja procurar o usuario\n1-nome\n2-cpf:", "Verificar Saldo", JOptionPane.QUESTION_MESSAGE);
                    op = Integer.parseInt(input);
                    switch (op) {
                        case 1 -> {
                            pos = buscaruser(name);
                            if (pos == 15) {
                                JOptionPane.showMessageDialog(null,"Usuario não encontrado!","Verificar Saldo", JOptionPane.WARNING_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null,"Nome: " + name[pos]+ "\nCpf: " + cpf[pos] + "\nCel: " + cel[pos]+ "\nSaldo: " + saldo[pos] + " R$");
                            }
                        }
                        case 2 -> {
                            pos = buscarcpf(cpf);
                            if (pos == 99) {
                                JOptionPane.showMessageDialog(null,"Usuario nao encontrado!", "Verificar saldo", JOptionPane.WARNING_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null,"Nome: " + name[pos] + "\n CPF: " + cpf[pos] + "\nCel: " + cel[pos] + "\nSaldo: " + saldo[pos] + " R$" );
                            }
                        }
                    }
                }
            }
        }
    }

    private static float IntegerparseFloat(String input) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    }
