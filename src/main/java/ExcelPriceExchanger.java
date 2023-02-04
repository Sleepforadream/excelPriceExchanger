import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import java.io.*;
import java.util.Objects;

public class ExcelPriceExchanger {

    public void priceMultiplication(int multiplier, File file) throws IOException {

        FileInputStream inputStream;
        try {
            inputStream = new FileInputStream(file);
        } catch (NullPointerException ioException) {
            ErrorDialogNotChooseFile errorDialog = new ErrorDialogNotChooseFile();
            errorDialog.createDialog(true);
            throw new RuntimeException(ioException);
        }

        XSSFWorkbook workbook;
        try {
            workbook = new XSSFWorkbook(inputStream);
        } catch (IOException ioException) {
            throw new RuntimeException(ioException);
        }

        for (Sheet sheet : workbook) {
            for (Row row : sheet) {
                for (Cell cell : row) {
                    CellStyle style = cell.getCellStyle();
                    if (Objects.equals(validateNumbers(cell), "Number") && (style.getDataFormat() == 165 || style.getDataFormat() == 164)) {
                        cell.setCellValue(cell.getNumericCellValue() * multiplier);
                    }
                }
            }
        }
        inputStream.close();
        FileOutputStream out = new FileOutputStream(file);
        workbook.write(out);
        out.close();
    }

    public void priceMultiplication(double multiplier, File file) throws IOException {

        FileInputStream inputStream;
        try {
            inputStream = new FileInputStream(file);
        } catch (NullPointerException ioException) {
            ErrorDialogNotChooseFile errorDialog = new ErrorDialogNotChooseFile();
            errorDialog.createDialog(true);
            throw new RuntimeException(ioException);
        }

        XSSFWorkbook workbook;
        try {
            workbook = new XSSFWorkbook(inputStream);
        } catch (IOException ioException) {
            throw new RuntimeException(ioException);
        }

        for (Sheet sheet : workbook) {
            for (Row row : sheet) {
                for (Cell cell : row) {
                    CellStyle style = cell.getCellStyle();
                    if (Objects.equals(validateNumbers(cell), "Number") && (style.getDataFormat() == 165 || style.getDataFormat() == 164)) {
                        cell.setCellValue(cell.getNumericCellValue() * multiplier);
                    }
                }
            }
        }
        inputStream.close();
        FileOutputStream out = new FileOutputStream(file);
        workbook.write(out);
        out.close();
    }

    public void priceDivider(int divider, File file) throws IOException {

        FileInputStream inputStream;
        try {
            inputStream = new FileInputStream(file);
        } catch (NullPointerException ioException) {
            ErrorDialogNotChooseFile errorDialog = new ErrorDialogNotChooseFile();
            errorDialog.createDialog(true);
            throw new RuntimeException(ioException);
        }

        XSSFWorkbook workbook;
        try {
            workbook = new XSSFWorkbook(inputStream);
        } catch (IOException ioException) {
            throw new RuntimeException(ioException);
        }

        for (Sheet sheet : workbook) {
            for (Row row : sheet) {
                for (Cell cell : row) {
                    CellStyle style = cell.getCellStyle();
                    if (Objects.equals(validateNumbers(cell), "Number") && (style.getDataFormat() == 165 || style.getDataFormat() == 164)) {
                        cell.setCellValue(cell.getNumericCellValue() / divider);
                    }
                }
            }
        }
        inputStream.close();
        FileOutputStream out = new FileOutputStream(file);
        workbook.write(out);
        out.close();
    }

    public void priceDivider(double divider, File file) throws IOException {

        FileInputStream inputStream;
        try {
            inputStream = new FileInputStream(file);
        } catch (NullPointerException ioException) {
            ErrorDialogNotChooseFile errorDialog = new ErrorDialogNotChooseFile();
            errorDialog.createDialog(true);
            throw new RuntimeException(ioException);
        }

        XSSFWorkbook workbook;
        try {
            workbook = new XSSFWorkbook(inputStream);
        } catch (IOException ioException) {
            throw new RuntimeException(ioException);
        }

        for (Sheet sheet : workbook) {
            for (Row row : sheet) {
                for (Cell cell : row) {
                    CellStyle style = cell.getCellStyle();
                    if (Objects.equals(validateNumbers(cell), "Number") && (style.getDataFormat() == 165 || style.getDataFormat() == 164)) {
                        cell.setCellValue(cell.getNumericCellValue() / divider);
                    }
                }
            }
        }
        inputStream.close();
        FileOutputStream out = new FileOutputStream(file);
        workbook.write(out);
        out.close();
    }

    public void pricePercentAugment(int percent, File file) throws IOException {

        FileInputStream inputStream;
        try {
            inputStream = new FileInputStream(file);
        } catch (NullPointerException ioException) {
            ErrorDialogNotChooseFile errorDialog = new ErrorDialogNotChooseFile();
            errorDialog.createDialog(true);
            throw new RuntimeException(ioException);
        }

        XSSFWorkbook workbook;
        try {
            workbook = new XSSFWorkbook(inputStream);
        } catch (IOException ioException) {
            throw new RuntimeException(ioException);
        }

        for (Sheet sheet : workbook) {
            for (Row row : sheet) {
                for (Cell cell : row) {
                    CellStyle style = cell.getCellStyle();
                    if (Objects.equals(validateNumbers(cell), "Number") && (style.getDataFormat() == 165 || style.getDataFormat() == 164)) {
                        cell.setCellValue(cell.getNumericCellValue() + cell.getNumericCellValue() / 100 * percent);
                    }
                }
            }
        }
        inputStream.close();
        FileOutputStream out = new FileOutputStream(file);
        workbook.write(out);
        out.close();
    }

    public void pricePercentAugment(double percent, File file) throws IOException {

        FileInputStream inputStream;
        try {
            inputStream = new FileInputStream(file);
        } catch (NullPointerException ioException) {
            ErrorDialogNotChooseFile errorDialog = new ErrorDialogNotChooseFile();
            errorDialog.createDialog(true);
            throw new RuntimeException(ioException);
        }

        XSSFWorkbook workbook;
        try {
            workbook = new XSSFWorkbook(inputStream);
        } catch (IOException ioException) {
            throw new RuntimeException(ioException);
        }

        for (Sheet sheet : workbook) {
            for (Row row : sheet) {
                for (Cell cell : row) {
                    CellStyle style = cell.getCellStyle();
                    if (Objects.equals(validateNumbers(cell), "Number") && (style.getDataFormat() == 165 || style.getDataFormat() == 164)) {
                        cell.setCellValue(cell.getNumericCellValue() + (cell.getNumericCellValue() / 100 * percent));
                    }
                }
            }
        }
        inputStream.close();
        FileOutputStream out = new FileOutputStream(file);
        workbook.write(out);
        out.close();
    }

    public void pricePercentMinus(int percent, File file) throws IOException {

        FileInputStream inputStream;
        try {
            inputStream = new FileInputStream(file);
        } catch (NullPointerException ioException) {
            ErrorDialogNotChooseFile errorDialog = new ErrorDialogNotChooseFile();
            errorDialog.createDialog(true);
            throw new RuntimeException(ioException);
        }

        XSSFWorkbook workbook;
        try {
            workbook = new XSSFWorkbook(inputStream);
        } catch (IOException ioException) {
            throw new RuntimeException(ioException);
        }

        for (Sheet sheet : workbook) {
            for (Row row : sheet) {
                for (Cell cell : row) {
                    CellStyle style = cell.getCellStyle();
                    if (Objects.equals(validateNumbers(cell), "Number") && (style.getDataFormat() == 165 || style.getDataFormat() == 164)) {
                        cell.setCellValue(cell.getNumericCellValue() - (cell.getNumericCellValue() / 100 * percent));
                    }
                }
            }
        }
        inputStream.close();
        FileOutputStream out = new FileOutputStream(file);
        workbook.write(out);
        out.close();
    }

    public void pricePercentMinus(double percent, File file) throws IOException {

        FileInputStream inputStream;
        try {
            inputStream = new FileInputStream(file);
        } catch (NullPointerException ioException) {
            ErrorDialogNotChooseFile errorDialog = new ErrorDialogNotChooseFile();
            errorDialog.createDialog(true);
            throw new RuntimeException(ioException);
        }

        XSSFWorkbook workbook;
        try {
            workbook = new XSSFWorkbook(inputStream);
        } catch (IOException ioException) {
            throw new RuntimeException(ioException);
        }

        for (Sheet sheet : workbook) {
            for (Row row : sheet) {
                for (Cell cell : row) {
                    CellStyle style = cell.getCellStyle();
                    if (Objects.equals(validateNumbers(cell), "Number") && (style.getDataFormat() == 165 || style.getDataFormat() == 164)) {
                        cell.setCellValue(cell.getNumericCellValue() - cell.getNumericCellValue() / 100 * percent);
                    }
                }
            }
        }
        inputStream.close();
        FileOutputStream out = new FileOutputStream(file);
        workbook.write(out);
        out.close();
    }

    String validateNumbers(Cell cell) {
        try {
            cell.getStringCellValue();
            return "notNumber";
        } catch (IllegalStateException stateException) {
            try {
                cell.getNumericCellValue();
                return "Number";
            } catch (IllegalStateException stateException2) {
                return "notNumber";
            }
        }
    }
}