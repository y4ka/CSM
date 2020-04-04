package generated.MainPanels;

import javax.swing.JPanel;

import modele.Player;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Image;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;

public class PanelEquipeListeJoueur extends JPanel {
	private JLabel lblImage;
	private JLabel lblNickname;

	/**
	 * Create the panel.
	 */
	public PanelEquipeListeJoueur() {
		setBackground(Color.LIGHT_GRAY);
		setLayout(new BorderLayout(0, 0));
		
		lblImage = new JLabel("Missing Picture");
		add(lblImage, BorderLayout.CENTER);
		
		lblNickname = new JLabel("NickName");
		lblNickname.setHorizontalAlignment(SwingConstants.CENTER);
		lblNickname.setHorizontalTextPosition(SwingConstants.CENTER);
		add(lblNickname, BorderLayout.SOUTH);

	}

	public void update(Player player)
	{
		if(player != null)
		{
			//Nickname:
			lblNickname.setText(player.getNickname());
			
			//Image:
			int playerID = player.getId();
			ImageIcon playerImage = new ImageIcon("resources/pictures/"+playerID+".jpeg");
			if (playerImage != null)
			{
				playerImage = resizeImages(playerImage);
				lblImage.setIcon(playerImage);
				lblImage.setText(null);
			}
			else
			{
				lblImage.setText("Missing Picture"); // TODO Exceptions ?
			}
		}
		else
		{
			lblNickname.setText("Missing Player"); // TODO Exceptions ?
		}
	}
	
	private ImageIcon resizeImages(ImageIcon imageIcon) //TODO a appeler dans la surcharge du repaint.
	{
		int x, y;
		y = x = this.getParent().getSize().height;
		Image image = imageIcon.getImage(); 
		Image newimg = image.getScaledInstance(x, y,  java.awt.Image.SCALE_SMOOTH);
		return (new ImageIcon(newimg));
	}
}
