package com.example.sampleproject.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sampleproject.Model.AssetDescriptors;
import com.example.sampleproject.R;

import java.util.List;

public class AssetdescriptorAdapter extends RecyclerView.Adapter<AssetdescriptorAdapter.DescriptorViewHolder> {

        public List<AssetDescriptors> mListAssetDescriptor;

    public AssetdescriptorAdapter(List<AssetDescriptors> mListAssetDescriptor) {
        this.mListAssetDescriptor = mListAssetDescriptor;
    }

    @NonNull
    @Override
    public DescriptorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view   = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_assetdescriptors, parent, false);
        return new DescriptorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DescriptorViewHolder holder, int position) {
        AssetDescriptors assetDescriptors = mListAssetDescriptor.get(position);
        if (assetDescriptors == null){
            return;
        }
        holder.Tvname.setText(assetDescriptors.getName());
        holder.Tvcolour.setText(assetDescriptors.getColour());
        holder.Tvicon.setText(assetDescriptors.getIcon());
        holder.TvassetImport.setText(assetDescriptors.getAssetImport());
        holder.TvassetDiscovery.setText(assetDescriptors.getAssetDiscovery());
        holder.TvagentLinkType.setText(assetDescriptors.getAgentLinkType());
    }

    @Override
    public int getItemCount() {
        if (mListAssetDescriptor != null){
            return mListAssetDescriptor.size();
        }
        return 0;
    }

    public class DescriptorViewHolder extends RecyclerView.ViewHolder{

        public TextView Tvname,Tvicon, Tvcolour, TvassetDiscovery, TvassetImport, TvagentLinkType;

        public DescriptorViewHolder(@NonNull View itemView) {
            super(itemView);
            Tvname = itemView.findViewById(R.id.name);
            Tvicon =itemView.findViewById(R.id.Icon);
            Tvcolour= itemView.findViewById(R.id.colour);
            TvassetDiscovery = itemView.findViewById(R.id.assetDiscovery);
            TvassetImport = itemView.findViewById(R.id.assetImport);
            TvagentLinkType = itemView.findViewById(R.id.agentLinkType);
        }
    }
}
