/**
 * 
 */
package org.green.code.tmgusers.persistence;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;
import org.green.code.tmgusers.domain.User;

/**
 * The Interface TmgUsersMapper.
 * 
 * @author mattia.mascia
 */
public interface TmgUsersMapper {

	/**
	 * Select all.
	 * 
	 * @return the list
	 */
	@Select(value = "SELECT ID,NAME,DATE_OF_BIRTH FROM USER")
	@Results({
			@Result(property = "id", column = "ID", jdbcType = JdbcType.DECIMAL),
			@Result(property = "name", column = "NAME", jdbcType = JdbcType.VARCHAR),
			@Result(property = "dateOfBirthMills", column = "DATE_OF_BIRTH", jdbcType = JdbcType.BIGINT) })
	List<User> selectAll();

	/**
	 * Select by id.
	 * 
	 * @param id
	 *            the id
	 * @return the list
	 */
	@Select({ "SELECT ID,NAME,DATE_OF_BIRTH FROM USER",
			"WHERE ID = #{id,jdbcType=DECIMAL}" })
	@Results({
			@Result(property = "id", column = "ID", jdbcType = JdbcType.DECIMAL, id = true),
			@Result(property = "name", column = "NAME", jdbcType = JdbcType.VARCHAR),
			@Result(property = "dateOfBirthMills", column = "DATE_OF_BIRTH", jdbcType = JdbcType.BIGINT) })
	User selectById(BigDecimal id);

	/**
	 * Insert.
	 * 
	 * @param user
	 *            the user
	 * @return the int
	 */
	@Insert({ "insert into USER (ID, NAME, ", "DATE_OF_BIRTH)",
			"values (#{id,jdbcType=DECIMAL}," + "",
			"#{name,jdbcType=VARCHAR}, #{dateOfBirthMills,jdbcType=BIGINT})" })
	int insert(User user);

	/**
	 * Update.
	 * 
	 * @param id
	 *            the id
	 * @return the int
	 */
	@Update({ "update USER", "set NAME = #{name,jdbcType=VARCHAR},",
			"DATE_OF_BIRTH = #{dateOfBirthMills,jdbcType=BIGINT}",
			"WHERE ID = #{id,jdbcType=DECIMAL}" })
	int update(User user);

	/**
	 * Delete.
	 * 
	 * @param id
	 *            the id
	 * @return the int
	 */
	@Delete({ "DELETE FROM USER", "WHERE ID = #{id,jdbcType=DECIMAL}" })
	int delete(BigDecimal id);
}
