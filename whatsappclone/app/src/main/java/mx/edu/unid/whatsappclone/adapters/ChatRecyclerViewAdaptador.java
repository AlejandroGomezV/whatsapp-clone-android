package mx.edu.unid.whatsappclone.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import mx.edu.unid.whatsappclone.R;
import mx.edu.unid.whatsappclone.models.ChatModelo;

public class ChatRecyclerViewAdaptador extends RecyclerView.Adapter<ChatRecyclerViewAdaptador.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView mensajeR, horaR, mensajeE, horaE;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mensajeR = itemView.findViewById(R.id.mensajecontacto);
            horaR = itemView.findViewById(R.id.horacontacto);
            mensajeE = itemView.findViewById(R.id.mensajeme);
            horaE = itemView.findViewById(R.id.horame);
        }
    }

    public List<ChatModelo> chatLista;

    public ChatRecyclerViewAdaptador(List<ChatModelo> chatLista) {
        this.chatLista = chatLista;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chat,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mensajeR.setText(chatLista.get(position).getMensajeR());
        holder.horaR.setText(chatLista.get(position).getHoraR());
        holder.mensajeE.setText(chatLista.get(position).getMensajeE());
        holder.horaE.setText(chatLista.get(position).getHoraE());
    }

    @Override
    public int getItemCount() {
        return chatLista.size();
    }
}
