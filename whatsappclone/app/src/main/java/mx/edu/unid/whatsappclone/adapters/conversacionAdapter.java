package mx.edu.unid.whatsappclone.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

import mx.edu.unid.whatsappclone.R;
import mx.edu.unid.whatsappclone.models.ConversacionModelo;

public class conversacionAdapter extends FirestoreRecyclerAdapter<ConversacionModelo, conversacionAdapter.ViewHolder> {


    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public conversacionAdapter(@NonNull FirestoreRecyclerOptions<ConversacionModelo> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder viewHolder, int i, @NonNull ConversacionModelo conversacion) {
        String miusuario = "Alex";
        if(conversacion.getFrom()==miusuario) {
            viewHolder.textViewContacto.setText(conversacion.getTo());
        }
        else {
            viewHolder.textViewContacto.setText(conversacion.getFrom());
        }
        viewHolder.textViewFecha.setText("02:04 p.m.");
        viewHolder.textViewMensaje.setText(conversacion.getMessage());
        viewHolder.textViewNotificacion.setText("3");
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_conversacion, parent, false);
        return new ViewHolder(view);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textViewContacto;
        TextView textViewFecha;
        TextView textViewMensaje;
        TextView textViewNotificacion;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewContacto = itemView.findViewById(R.id.nombreConversacion);
            textViewFecha = itemView.findViewById(R.id.horaConversacion);
            textViewMensaje = itemView.findViewById(R.id.mensajeConversacion);
            textViewNotificacion = itemView.findViewById(R.id.notificacionConversacion);
        }
    }
}