package net.sourceforge.texlipse.actions;

import net.sourceforge.texlipse.editor.TexEditor;
import net.sourceforge.texlipse.model.TexOutlineInput;
import net.sourceforge.texlipse.outline.QuickOutline;
import net.sourceforge.texlipse.treeview.views.TexOutlineTreeView;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;

/** This action opens the quick outline in the OCaml editor. */
public class OpenQuickOutlineAction implements IEditorActionDelegate {
    private TexEditor editor;


	public void run(IAction action) {
		TexOutlineTreeView treeView = editor.getFullOutline();
		TexOutlineInput outlineInput = treeView.getTexOutlinePage().getTexOutlineInput();
		if(outlineInput != null) {
			QuickOutline quickOutline =
					new QuickOutline(Display.getCurrent().getActiveShell(), 
							outlineInput, editor);
			quickOutline.open();
			quickOutline.setFocus();
		}
	}

	public void dispose() {
	}

	public void init(IWorkbenchWindow window) {
	}

	public void selectionChanged(IAction action, ISelection selection) {
	}

    public void setActiveEditor(IAction action, IEditorPart part) {
        if (part instanceof TexEditor)
        	editor = (TexEditor) part;
        else
        	editor = null;
    }

}
