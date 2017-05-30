/*
 * Autopsy Forensic Browser
 *
 * Copyright 2011-17 Basis Technology Corp.
 * Contact: carrier <at> sleuthkit <dot> org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.sleuthkit.autopsy.corecomponents;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import javax.swing.SwingUtilities;
import org.openide.nodes.Node;
import org.sleuthkit.autopsy.corecomponents.ResultViewerPersistence.SortCriterion;

public class SortChooser extends javax.swing.JPanel {

    private final List<Node.Property<?>> availableProps;
    private final ArrayList<CriterionPicker> pickers = new ArrayList<>();

    /**
     * @param availableProps The properties that are available for selection in
     *                       this SortChooser.
     */
    public SortChooser(List<Node.Property<?>> availableProps) {
        super();
        initComponents();

        this.availableProps = availableProps;
        final CriterionPicker criterionPicker = CriterionPicker.create(availableProps);
        pickers.add(criterionPicker);
        scrollContent.add(criterionPicker);
    }

    List<SortCriterion> getCriteria() {
        List<SortCriterion> list = new ArrayList<>();
        for (int i = 0; i < pickers.size(); i++) {
            list.add(pickers.get(i).getSelectedCriteria(i));
        }
        return list;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        scrollContent = new javax.swing.JPanel();
        addCriteriaButton = new javax.swing.JButton();

        scrollContent.setLayout(new javax.swing.BoxLayout(scrollContent, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(scrollContent);

        org.openide.awt.Mnemonics.setLocalizedText(addCriteriaButton, org.openide.util.NbBundle.getMessage(SortChooser.class, "SortChooser.addCriteriaButton.text")); // NOI18N
        addCriteriaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCriteriaButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addCriteriaButton)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addCriteriaButton)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addCriteriaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCriteriaButtonActionPerformed
        final CriterionPicker criterionPicker = CriterionPicker.create(availableProps, picker -> {
            SwingUtilities.invokeLater(() -> {
                pickers.remove(picker);
                scrollContent.remove(picker);
                revalidate();
                repaint();
            });
        });
        pickers.add(criterionPicker);
        scrollContent.add(criterionPicker);
        revalidate();
    }//GEN-LAST:event_addCriteriaButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addCriteriaButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel scrollContent;
    // End of variables declaration//GEN-END:variables

}
