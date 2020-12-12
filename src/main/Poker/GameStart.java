package Poker;

import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;

public class GameStart {
	
	private boolean IsGameEnd;
	
	public int getBiggestHand(List<Player> players) {
		int biggestHand = players.get(0).getIndDeck().size();
		int pBigHand = 0;
		for(int i = 0; i < 4; i++) {
			if(players.get(i).getIndDeck().size() > biggestHand) {
				pBigHand = i;
			}
		}
		return pBigHand;
	}
	
	public boolean IsGameEnd(Player playerUse) {
		return playerUse.getIndDeck().isEmpty();
	}
	
	public static void main(String[] args) {
		GameStart round = new GameStart();
		
		Scanner input = new Scanner(System.in);
		
		Deck deck = new Deck();
		
		deck.shuffle();
		
		//deck.showDeck();
		
		List<Player> players = new ArrayList<Player>();
		
		for(int i = 0; i <= 3; i++) {
			players.add(new Player(i, "i"));
			for(int j = 0; j <= 12; j++) {
				players.get(i).setIndDeck(deck.getDeck().get((i+ 1) * (j + 1) - 1));
			}
			players.get(i).showIndDeck();
			players.get(i).removeDuplicates();
			players.get(i).showIndDeck();
		}
		
		int pBigHand = round.getBiggestHand(players);
		
		System.out.println(round.getBiggestHand(players));
		
		while(!round.IsGameEnd) {
			for(int i = pBigHand; i <= pBigHand + 3; i++) {
				if(i > 3) {
					
					players.get(i - 4).showIndDeck();
					
					System.out.println("Choose from 1 to " + players.get(i - 4).getIndDeck().size());
					
					int number = input.nextInt();
					
					Card cardPicked = players.get(i - 4).getIndDeck().get(number - 1);
					
					players.get(i - 4).removeCard(number - 1);
					
					if(round.IsGameEnd(players.get(i - 4))) {
						System.out.println("Winner is Player # " + (i - 4));
						
						round.IsGameEnd = true;
						
						break;
					}
					
					players.get(i - 3).setIndDeck(cardPicked);
					
					System.out.println(cardPicked.getSuit() + cardPicked.getCardNum());
					
					players.get(i - 3).removeDuplicates();
					
					if(round.IsGameEnd(players.get(i - 3))) {
						System.out.println("Winner is Player # " + (i - 3));
						
						round.IsGameEnd = true;
						
						break;
					}
				}
				else {
					players.get(i).showIndDeck();
					
					System.out.println("Choose from 1 to " + players.get(i).getIndDeck().size());
					
					int number = input.nextInt();
					
					Card cardPicked = players.get(i).getIndDeck().get(number - 1);
					
					System.out.println(cardPicked.getSuit() + cardPicked.getCardNum());
					
					players.get(i).removeCard(number - 1);
					
					if(round.IsGameEnd(players.get(i))) {
						System.out.println("Winner is Player # " + (i));
						
						round.IsGameEnd = true;
						
						break;
					}
					
					if(i == 3) {
						players.get(0).setIndDeck(cardPicked);
						
						players.get(0).removeDuplicates();
						
						if(round.IsGameEnd(players.get(0))) {
							System.out.println("Winner is Player # " + (0));
							
							round.IsGameEnd = true;
							
							break;
						}
					}
					else {
						players.get(i + 1).setIndDeck(cardPicked);
						
						players.get(i + 1).removeDuplicates();
						
						if(round.IsGameEnd(players.get(i + 1))) {
							System.out.println("Winner is Player # " + (i + 1));
							
							round.IsGameEnd = true;
							
							break;
						}
					}
					
					
				}
			}
			
			for(int i = 0; i <= 3; i++) {
				players.get(i).showIndDeck();
			}
			
			
		}
		input.close();
	}
	
}
