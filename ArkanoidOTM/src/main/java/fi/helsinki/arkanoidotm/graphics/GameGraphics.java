package fi.helsinki.arkanoidotm.graphics;

import fi.helsinki.arkanoidotm.game.Game;
import fi.helsinki.arkanoidotm.game.components.Ball;
import fi.helsinki.arkanoidotm.game.components.Block;
import fi.helsinki.arkanoidotm.game.highscore.HighScore;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;

public class GameGraphics {
    
    public void renderGame(Graphics g, Game game) {   
        g.translate((game.getWidth() - game.getGameField().width) / 2, (game.getHeight() - game.getGameField().height) / 2);
        g.setColor(Color.white);
        g.fillRect(0, 0, game.getGameField().width, game.getGameField().height);
        g.setColor(Color.black);
        g.drawRect(0, 0, game.getGameField().width, game.getGameField().height);
        for (Block[] xBlocks : game.getBlocks()) {
            for (Block block : xBlocks) {
                renderBlock(g, block);
            }
        }
        renderText(g, game);
        renderBall(g, game.getGameBall());
        renderBoard(g, game.getGameBoard().getBoard());
    }

    public void renderText(Graphics g, Game game) {
        g.drawString("Lives: " + game.lives, 0, -5);
        g.drawString("Score: " + game.getGameScore(), 100, -5);
        if (!game.running && !game.lost && !game.won) {
            g.drawString("Press ENTER to start", game.getWidth() - game.getGameField().width, game.getHeight() - game.getGameField().height);
            g.drawString("Use the mouse to move", game.getWidth() - game.getGameField().width, game.getHeight() - game.getGameField().height + 15);
        } else if (!game.running && game.lost && !game.won) {
            g.drawString("You LOST!", game.getWidth() - game.getGameField().width + 5, game.getHeight() - game.getGameField().height - 15);
            g.drawString("Press ENTER to start again", game.getWidth() - game.getGameField().width, game.getHeight() - game.getGameField().height);
        }
    }
    
    public void renderBall(Graphics g, Ball ball) {
        g.setColor(Color.black);
        g.fillOval(ball.getPosition().x - ball.getRadius(), ball.getPosition().y - ball.getRadius(), ball.getRadius() * 2, ball.getRadius() * 2);
    }
    
    public void renderBoard(Graphics g, Rectangle board) {
        g.setColor(new Color(200, 200, 200));
        g.fillRect(board.x, board.y, board.width, board.height);
    }
    
    public void renderBlock(Graphics g, Block block) {
        if (!block.getDestroyed()) {
            g.setColor(Color.RED);
            g.fillRect(block.getBlock().x, block.getBlock().y, block.getBlock().width, block.getBlock().height);
            g.setColor(Color.BLACK);
            g.drawRect(block.getBlock().x, block.getBlock().y, block.getBlock().width, block.getBlock().height);
        }
    }
    
    public void renderHighScore(Graphics g, HighScore score, Dimension field) {
        g.setColor(Color.white);
        g.fillRect(field.width / 2 - 100, field.height / 3, 200, field.height / 2);
        g.setColor(Color.black);
        g.drawRect(field.width / 2 - 100, field.height / 3, 200, field.height / 2);
        g.translate(field.width / 2 - 100, field.height / 3);
        renderScores(g, score);
    }
    
    public void renderScores(Graphics g, HighScore score) {
        /*g.drawString("HighScores", 10, 15);
        for (int i = 1; i < 11; i++) {
            g.drawString(i + ". ASD: " + score.getScore() + " points", 10, 15 * i + 15);    
        }*/
        g.drawString("Congratulations, you won!", 10, 15);
        g.drawString("Your score is: "+ score.getScore() + " points", 10, 100);
        g.drawString("Press ENTER to start again", 10, 195);
    }
}