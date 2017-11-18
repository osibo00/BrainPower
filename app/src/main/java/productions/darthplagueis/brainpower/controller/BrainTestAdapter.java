package productions.darthplagueis.brainpower.controller;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import productions.darthplagueis.brainpower.R;
import productions.darthplagueis.brainpower.model.BrainTest;

public class BrainTestAdapter extends RecyclerView.Adapter<BrainTestAdapter.BrainTestViewHolder> {

    private List<BrainTest> brainTestList;

    public BrainTestAdapter(List<BrainTest> brainTestList) {
        this.brainTestList = brainTestList;
    }

    @Override
    public BrainTestViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View childView = LayoutInflater.from(parent.getContext()).inflate(R.layout.braintest_itemview, parent, false);
        return new BrainTestViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(final BrainTestAdapter.BrainTestViewHolder holder, int position) {
        final BrainTest brainTest = brainTestList.get(position);
        holder.brainTestText.setText(brainTest.getQuestion());
        holder.view.setBackgroundColor(brainTest.isSelected() ? Color.CYAN : Color.WHITE);
        holder.brainTestText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                brainTest.setSelected(!brainTest.isSelected());
                holder.view.setBackgroundColor(brainTest.isSelected() ? Color.CYAN : Color.WHITE);
            }
        });
    }

    @Override
    public int getItemCount() {
        return brainTestList == null ? 0 : brainTestList.size();
    }

    public class BrainTestViewHolder extends RecyclerView.ViewHolder {

        private View view;
        private TextView brainTestText;

        public BrainTestViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            brainTestText = (TextView) itemView.findViewById(R.id.braintest_textview);
        }
    }
}
