package com.cout970.worldeditor.gui;

import java.util.ArrayList;
import java.util.List;

public class GuiPanel {

	public List<GuiBoton> buttons = new ArrayList<GuiBoton>();
	
	public GuiPanel(){
		buttons.add(new GuiBotonActionSelector(8, (int)ToolBox.finishY-35, (int)ToolBox.finishX-16, 25,"Select"));
		buttons.add(new GuiBotonMaterial(8, (int)ToolBox.finishY-155, (int)ToolBox.finishX-16, 110,"Material"));
		buttons.add(new GuiBotonCuentaGotas(8, (int)ToolBox.finishY-190, (int)ToolBox.finishX-16, 25,"Selector"));
		buttons.add(new GuiBotonColorEditor(8, (int)ToolBox.finishY-315, (int)ToolBox.finishX-16, 110,"Color Editor"));
	}
	
}
