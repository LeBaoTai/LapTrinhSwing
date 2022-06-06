package GUI;

import BLL.ThongTinSVBUS;
import DAL.ThongTinSVDAL;
import DTO.ThongTinSVDTO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class MainPage extends JFrame {
    DefaultTableModel defaultTableModel;

    public MainPage() {

        // bang thong tin sinh vien
        defaultTableModel = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        defaultTableModel.addColumn("MSSV");
        defaultTableModel.addColumn("Ho va ten");
        defaultTableModel.addColumn("Lop");
        defaultTableModel.addColumn("Khoa");
        setData();
        JTable thongTinTable = new JTable(defaultTableModel);
        thongTinTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        thongTinTable.setSelectionBackground(Color.pink);
        thongTinTable.setSelectionForeground(null);

        JScrollPane scrollPaneTable = new JScrollPane(thongTinTable);
        scrollPaneTable.setBounds(0,0, 700, 700);

        // nut them
        JButton bAdd = new JButton();
        bAdd.setText("Them");
        bAdd.setFocusable(false);
        bAdd.setBounds(750, 50, 200, 50);
        bAdd.addActionListener(e -> {
            // dialog them thong tin vien sien
            JDialog dialog = new JDialog();

            JLabel lMssv = new JLabel("Nhap Mssv");
            JTextField fMssv = new JTextField();
            fMssv.setColumns(25);

            JLabel lHoTen = new JLabel("Nhap Ho va Ten");
            JTextField fHoTen = new JTextField();
            fHoTen.setColumns(25);

            JLabel lLop = new JLabel("Nhap Lop");
            JTextField fLop = new JTextField();
            fHoTen.setColumns(25);

            JLabel lKhoa = new JLabel("Nhap Khoa");
            JTextField fKhoa = new JTextField();
            fHoTen.setColumns(25);

            JButton button = new JButton();
            button.setText("Them");
            button.setFocusable(false);
            button.addActionListener(a -> {
                if (
                        fMssv.getText().equals("")
                        || fHoTen.getText().equals("")
                        || fLop.getText().equals("")
                        || fKhoa.getText().equals("")
                ) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Khong duoc de trong",
                            "ERROR",
                            JOptionPane.ERROR_MESSAGE,
                            null
                    );
                }
                else {
                    String mssv = fMssv.getText();
                    String hoTen = fHoTen.getText();
                    String lop = fLop.getText();
                    String khoa = fKhoa.getText();

                    System.out.println(mssv);

                    boolean checkThongTin = new ThongTinSVBUS(mssv).checkThongTin();
                    if (!checkThongTin) {
                        JOptionPane.showMessageDialog(
                                null,
                                "MSSV da ton tai",
                                "ERROR",
                                JOptionPane.ERROR_MESSAGE,
                                null
                        );
                    } else {
                        ThongTinSVDTO thongTinSVDTO = new ThongTinSVDTO(mssv, hoTen, lop, khoa);
                        try {
                            boolean checkAdd = new ThongTinSVDAL().insertData(thongTinSVDTO);
                            if (checkAdd) {
                                JOptionPane.showMessageDialog(
                                        null,
                                        "Da them thanh cong"
                                );
                                dialog.dispose();
                                setData();
                            }
                            else {
                                JOptionPane.showMessageDialog(
                                        null,
                                        "Da xay ra loi"
                                );
                            }
                        } catch (Exception ex) {
                            throw new RuntimeException(ex);
                        }
                    }

                }
            });

            dialog.add(lMssv);
            dialog.add(fMssv);
            dialog.add(lHoTen);
            dialog.add(fHoTen);
            dialog.add(lLop);
            dialog.add(fLop);
            dialog.add(lKhoa);
            dialog.add(fKhoa);
            dialog.add(button);

            dialog.setLayout(new GridLayout(5,2, 0, 15));
            dialog.setTitle("Them thong tin sinh vien");
            dialog.pack();
            dialog.setVisible(true);
            dialog.setLocationRelativeTo(this);
        });

        // nut xoa
        JButton bDelete = new JButton();
        bDelete.setText("Xoa");
        bDelete.setFocusable(false);
        bDelete.setBounds(750, 130, 200, 50);
        bDelete.addActionListener(e -> {
            int rs = JOptionPane.showConfirmDialog(this, "Ban co chac chan xoa");
            if (rs == 0) {
                int row = thongTinTable.getSelectedRow();
                final int column = 0;
                String data = thongTinTable.getValueAt(row, column).toString();
                try {
                    boolean checkDelete = new ThongTinSVDAL().deleteData(data);
                    if (checkDelete) {
                        JOptionPane.showMessageDialog(
                                null,
                                "Da xoa thanh cong"
                        );
                        setData();
                    }
                    else {
                        JOptionPane.showMessageDialog(
                                null,
                                "Da xay ra loi"
                        );
                    }
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        // nut sua
        JButton bEdit = new JButton();
        bEdit.setText("Sua");
        bEdit.setFocusable(false);
        bEdit.setBounds(750, 210, 200, 50);
        bEdit.addActionListener(e -> {
            int row = thongTinTable.getSelectedRow();
            int column = thongTinTable.getSelectedColumn();
            String dataCu = thongTinTable.getValueAt(row, column).toString();
            String mssv = thongTinTable.getValueAt(row, 0).toString();

            //tao dialog cho viec xoa
            JDialog dialogEdit = new JDialog();

            JLabel labelCu = new JLabel();
            labelCu.setText("Gia tri cu:  " + dataCu);

            JLabel labelMoi = new JLabel();
            labelMoi.setText("Nhap vao gia tri moi: ");
            JTextField field = new JTextField();
            field.setColumns(20);

            JPanel panel = new JPanel();
            panel.add(labelMoi, BorderLayout.WEST);
            panel.add(field, BorderLayout.EAST);

            JButton button = new JButton();
            button.setText("Xac nhan");
            button.addActionListener(a -> {
                if (field.getText().equals("")) {
                    JOptionPane.showMessageDialog(
                            field,
                            "Khong duoc de trong!!!",
                            "ERROR",
                            JOptionPane.ERROR_MESSAGE,
                            null
                    );
                } else {
                    int rs = JOptionPane.showConfirmDialog(
                            null,
                            "Ban chac chan thay doi",
                            "Sua",
                            JOptionPane.YES_NO_OPTION
                    );
                    if (rs == 0) {
                        try {
                            // lay du lieu moi nhap vao qua textfield
                            String dataMoi = field.getText();
                            boolean checkThongTin = new ThongTinSVBUS(dataMoi).checkThongTin();
                            if (checkThongTin) {
                                boolean checkEdit = new ThongTinSVDAL().updateData(dataMoi, mssv, column);
                                if (checkEdit) {
                                    JOptionPane.showMessageDialog(
                                            null,
                                            "Thay doi thanh cong"
                                    );
                                    setData();
                                } else {
                                    JOptionPane.showMessageDialog(
                                            null,
                                            "Da xay ra loi"
                                    );
                                }
                            } else {
                                JOptionPane.showMessageDialog(
                                        null,
                                        "MSSV da ton tai",
                                        "ERROR",
                                        JOptionPane.ERROR_MESSAGE,
                                        null
                                );
                            }
                        } catch (Exception ex) {
                            throw new RuntimeException(ex);
                        }
                        dialogEdit.dispose();
                        setData();
                    }
                }
            });

            dialogEdit.add(labelCu);
            dialogEdit.add(panel);
            dialogEdit.add(button);

            dialogEdit.setLayout(new GridLayout(3, 1, 4, 4));
            dialogEdit.setTitle("Chinh sua");
            dialogEdit.pack();
            dialogEdit.setLocationRelativeTo(null);
            dialogEdit.setVisible(true);
        });

        this.setTitle("Danh sach hoc sinh");
        this.add(scrollPaneTable);
        this.add(bAdd);
        this.add(bDelete);
        this.add(bEdit);

        this.setLayout(null);
        this.setSize(1000, 700);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
//        this.setResizable(false);
    }

    private void setData() {
        try {
            defaultTableModel.setRowCount(0);
            ArrayList<ThongTinSVDTO> listThongTinSV = new ThongTinSVDAL().getData();
            for (ThongTinSVDTO SV: listThongTinSV) {
                defaultTableModel.addRow(new Object[]{
                        SV.get__msMssv(),
                        SV.get__msHoTen(),
                        SV.get__msLop(),
                        SV.get__msKhoa(),
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void add(ThongTinSVDTO sv) {
        boolean check = new ThongTinSVBUS(sv.get__msMssv()).checkThongTin();

        if (!check) {
            JOptionPane.showMessageDialog(
                    null,
                    "Bi trung MSSV",
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE,
                    null
            );
        } else {
            try {
                boolean thongTinSVDAL = new ThongTinSVDAL().insertData(sv);
                System.out.println(thongTinSVDAL);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}