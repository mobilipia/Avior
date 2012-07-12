// This application window displays information about the Avior module

package view;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;

public class About {

	protected Shell shell;
	protected Display display;

	/**
	 * Create the dialog.
	 * 
	 * @param parent
	 * @param style
	 */
	public About() {
		open();
	}

	/**
	 * Open the dialog.
	 * 
	 * @return the result
	 */
	public void open() {
		display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shell = new Shell();
		shell.setSize(375, 375);
		shell.setText("About");
		shell.setLayout(new GridLayout(2, false));
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);

		Label lblFloodlightOpenflowControl = new Label(shell, SWT.NONE);
		lblFloodlightOpenflowControl
				.setText("Avior | Floodlight Control Module");
		lblFloodlightOpenflowControl.setLayoutData(new GridData(SWT.CENTER,
				SWT.CENTER, false, false, 1, 1));
		new Label(shell, SWT.NONE);

		Label lblDevelopedByJason = new Label(shell, SWT.NONE);
		lblDevelopedByJason.setText("Developed by Jason Parraga,");
		lblDevelopedByJason.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));
		new Label(shell, SWT.NONE);

		Label ryan = new Label(shell, SWT.NONE);
		ryan.setText("in coordination with Ryan Wallner and Ryan Flaherty");
		ryan.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false,
				1, 1));
		new Label(shell, SWT.NONE);

		Label lblForTheMarist = new Label(shell, SWT.NONE);
		lblForTheMarist.setText("for the Marist Openflow Research Project");
		lblForTheMarist.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);

		Button project = new Button(shell, SWT.NONE);
		project.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false,
				false, 1, 1));
		project.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(
							new URI("http://openflow.marist.edu/"));
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (URISyntaxException ee) {
					ee.printStackTrace();
				}
			}
		});
		project.setText("Project Homepage");
		new Label(shell, SWT.NONE);

		Button source = new Button(shell, SWT.NONE);
		source.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false,
				1, 1));
		source.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(
							new URI("https://github.com/Sovietaced/Avior"));
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (URISyntaxException ee) {
					ee.printStackTrace();
				}
			}
		});
		source.setText("Project Source");
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);

		try {
			ImageData ideaImage = new ImageData(getClass().getResourceAsStream(
					"marist.gif"));
			Image marist = new Image(display, ideaImage);
			Label lblNewLabel_2 = new Label(shell, SWT.NONE);
			lblNewLabel_2.setImage(marist);
			lblNewLabel_2.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
					false, false, 1, 1));
		} catch (Exception j) {
			System.out.println("OSX Error");
		}

	}
}