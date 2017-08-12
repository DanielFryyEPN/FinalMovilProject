package ec.edu.epn.finalmovilproject;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by danie on 6/13/2017.
 */

public class HelpDialog extends DialogFragment {
    private View view;
    private TextView txtEmail;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        view = getActivity().getLayoutInflater().inflate(R.layout.dialog_ayuda, null);
        txtEmail = (TextView) view.findViewById(R.id.txtEmailDialog);
        builder.setView(view)
                .setTitle(getString(R.string.help))
                .setPositiveButton(getString(R.string.button_ok), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(TextUtils.isEmpty(txtEmail.getText().toString()))
                            txtEmail.setError(getString(R.string.error_campo_requerido));
                        else
                            Toast.makeText(getActivity(), "Se ha enviado a su correo una nueva contraseña", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton(getString(R.string.button_cancel), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dismiss();
                    }
                });
        return builder.create();
    }
}
