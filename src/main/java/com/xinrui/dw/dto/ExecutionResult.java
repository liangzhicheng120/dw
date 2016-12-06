package com.xinrui.dw.dto;

/**
 * 
 * @ClassName: ExecutionResult
 * @Description: 封住json结果,success true:输出data;success false 输error
 * @author liangzhicheng
 * @date 2016年12月6日 下午4:11:47
 *
 */
public class ExecutionResult<T>
{
	private boolean success;

	private T data;

	private String error;

	public ExecutionResult(boolean success, String error)
	{
		this.success = success;
		this.error = error;
	}

	public ExecutionResult(boolean success, T data)
	{
		this.success = success;
		this.data = data;
	}

	public boolean isSuccess()
	{
		return success;
	}

	public void setSuccess(boolean success)
	{
		this.success = success;
	}

	public T getData()
	{
		return data;
	}

	public void setData(T data)
	{
		this.data = data;
	}

	public String getError()
	{
		return error;
	}

	public void setError(String error)
	{
		this.error = error;
	}

}
