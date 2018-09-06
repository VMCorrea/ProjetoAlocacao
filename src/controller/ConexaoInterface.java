package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;

public interface ConexaoInterface {
    Connection getConnection() throws ConexaoException;
    void close() throws ConexaoException;
	PreparedStatement prepareStatement(String query);
}
