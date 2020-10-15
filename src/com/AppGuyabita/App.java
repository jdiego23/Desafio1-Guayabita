package com.AppGuyabita;

import com.Domain.Guayabita;
import com.Domain.Jugador;

import javax.swing.*;
import java.util.Arrays;
public class App {
    public static final int JUGAR = 0;
    public static final int INSTRUCIONES = 1;

    public static void main(String[] args) {
        Guayabita guayabita = new Guayabita("Guayabita");
        int poteI,Dinero,dado,sDado,apuesta,opcionElegida,opcion,op;
        boolean seguir = true; boolean control;
        String nombreJugador;
        Icon icon = new ImageIcon(App.class.getResource("Guyabita.jpg"));
        String instrucciones ="Instrucciones\n El Juego consiste en que cada jugador lanza un dado, " +
                "el resultado\n debe de ser diferente de 1 y 6 si los obtine tendra una sancion 100.\nSi obtiene un numero diferente los paso son:\n" +
                "\n1: El jugador decide si apuesta o sede el turno al proximo jugador." +
                "\n2: Si apuesta debe ingresar cuanto desea apostar." +
                "\n3: El jugador debe lanzar de nuevo el dado." +
                "\n4: El jugador debe de obtener un numero mayor al anterios." +
                "\n5: Si lo obtiene gana lo apostado." +
                "\n6: Si obtiene un numero menor perdera.";
        
        while(seguir)
        {
            opcionElegida = JOptionPane.showOptionDialog(null, "Bienvenido al juego la Guayabita\n \nElija una opcion\n",
                    "Guayabita", 0, 0, icon, Arrays.asList("Jugar" ," Ver instrucciones").toArray(),null);

            switch (opcionElegida)
            {
                case  JUGAR: {
                    guayabita.setNroJugadores(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de jugadores\nNo hay limite de jugadores\n")));
                    for (int i = 0;i<guayabita.getNroJugadores();i++)
                    {
                        nombreJugador =JOptionPane.showInputDialog("Ingrese el nombre del jugador #" + (i+1));
                        Dinero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el Dinero del jugador #" + (i+1)));
                        Jugador jugador = new Jugador(nombreJugador,Dinero);
                        guayabita.getJugadores().add(jugador);
                    }
                    poteI = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el pote inicial",100));
                    guayabita.incrementoPote((poteI*guayabita.getNroJugadores()));

                    for (int i = 0;i<guayabita.getNroJugadores();i++)
                    {
                        guayabita.getJugadores().get(i).restaDinero( guayabita.getJugadores().get(i),poteI );
                    }

                    control= true;
                    while( guayabita.getPoteInicial() != 0 && control == true)
                    {
                        for (int i = 0; i <  guayabita.getJugadores().size(); i++)
                        {
                            opcion = JOptionPane.showConfirmDialog(null, guayabita.getJugadores().get(i).getNombre() + ", ¿Desea tirar los dados?", "Guayabita", JOptionPane.YES_NO_OPTION);
                            if (opcion == JOptionPane.YES_OPTION)
                            {
                                dado = guayabita.getJugadores().get(i).elegirDado();
                                Icon dados = new ImageIcon(App.class.getResource("dado " + dado + ".png"));

                                if (dado == 6 || dado == 1)
                                {
                                    JOptionPane.showMessageDialog(null, guayabita.getJugadores().get(i).getNombre() + ",este es tu dado\nLo siento debe de seder el turno" +
                                                    "\nPierde 1OO de su dinero como sancion ", "Guayabita", 0, dados);
                                    guayabita.getJugadores().get(i).restaDinero(guayabita.getJugadores().get(i), 100);
                                    //guayabita.incrementoPote(100);

                                    if(guayabita.getJugadores().get(i).getDinero()<= 0)
                                    {
                                        guayabita.getJugadores2().add(guayabita.getJugadores().get(i));
                                        guayabita.getJugadores().remove(i);

                                        if(guayabita.getJugadores().size() == 0)
                                        {
                                            JOptionPane.showMessageDialog(null, "No hay un jugador activo\nPerdieron su dinero" );
                                            control = false;
                                        }
                                    }
                                }
                                else
                                    {
                                        op = JOptionPane.showConfirmDialog(null, guayabita.getJugadores().get(i).getNombre() + ", este es tu dado\n" +"Su dinero es: "+ guayabita.getJugadores().get(i).getDinero() +
                                                        "\nEl pote esta en " + guayabita.getPoteInicial() +"\n¿Desea apostar?", "Guayabita", JOptionPane.YES_NO_OPTION, 0, dados);

                                        if (op == JOptionPane.YES_OPTION)
                                        {
                                            sDado = guayabita.getJugadores().get(i).elegirDado();
                                            Icon dado2 = new ImageIcon(App.class.getResource("dado " + sDado + ".png"));
                                            apuesta = Integer.parseInt(JOptionPane.showInputDialog("Digite la cantidad que desea apostar"));
                                            JOptionPane.showMessageDialog(null, guayabita.getJugadores().get(i).getNombre() + ",este es tu dado", "Guayabita", 0, dado2);

                                            if (dado < sDado)
                                             {
                                                 JOptionPane.showMessageDialog(null, "Felicitaciones acaba de ganar: " + apuesta);
                                                 guayabita.getJugadores().get(i).sumaDinero(guayabita.getJugadores().get(i), apuesta);
                                                guayabita.decrementoPote(apuesta);
                                             }
                                            else
                                                {
                                                    JOptionPane.showMessageDialog(null, "Lo siento acaba de perder: "+ apuesta);
                                                    guayabita.getJugadores().get(i).restaDinero(guayabita.getJugadores().get(i), apuesta);
                                                    guayabita.incrementoPote(apuesta);
                                                    if(guayabita.getJugadores().get(i).getDinero()<= 0)
                                                    {
                                                        guayabita.getJugadores2().add(guayabita.getJugadores().get(i));
                                                        guayabita.getJugadores().remove(i);

                                                       if(guayabita.getJugadores().size()==0)
                                                        {
                                                            JOptionPane.showMessageDialog(null, "No hay jugadores activo\n Perdieron su dinero " );
                                                            control = false;
                                                        }
                                                    }
                                                }
                                        }
                                    }
                            }
                            if(guayabita.getPoteInicial()==0)
                            {
                                break;
                            }
                        }
                    }
                    if(guayabita.getPoteInicial() == 0)
                    {
                        for (int j = 0;j< guayabita.getJugadores().size();j++)
                        {
                            guayabita.getJugadores2().add(guayabita.getJugadores().get(j));
                        }
                    }

                    if(guayabita.getPoteInicial() == 0 || guayabita.getJugadores().size() == 0)
                    {
                            for (int i = 0;i<guayabita.getJugadores2().size();i++) {
                            JOptionPane.showMessageDialog(null, guayabita.getJugadores2().get(i).getNombre() + " tiene " + guayabita.getJugadores2().get(i).getDinero());
                         }
                    }
                    guayabita.getJugadores().clear();
                    guayabita.getJugadores2().clear();
                    guayabita.setPoteInicial(0);

                    break;
                }
                case INSTRUCIONES: {
                    JOptionPane.showMessageDialog(null,instrucciones);
                    break;
                }
                default:{
                    seguir = false;
                }
            }
        }
    }
}
